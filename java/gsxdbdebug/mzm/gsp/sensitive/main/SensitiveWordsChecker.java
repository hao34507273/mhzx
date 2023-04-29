/*     */ package mzm.gsp.sensitive.main;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class SensitiveWordsChecker
/*     */ {
/*     */   private class Node
/*     */   {
/*     */     private boolean _isEnd;
/*     */     private Map<Character, Node> _subNodes;
/*     */     
/*     */     private Node()
/*     */     {
/*  28 */       this._isEnd = false;
/*  29 */       this._subNodes = new HashMap();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*  34 */   private final Map<Character, Node> _nodes = new HashMap();
/*     */   
/*  36 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void load(String path, String encode)
/*     */   {
/*  45 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  48 */       BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), encode));
/*     */       
/*     */       String word;
/*  51 */       while ((word = reader.readLine()) != null)
/*     */       {
/*  53 */         addSensitiveWord(word.trim());
/*     */       }
/*     */       
/*  56 */       reader.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  60 */       String err = String.format("加载敏感词文件失败！path=%s,encode=%s", new Object[] { path, encode });
/*  61 */       throw new RuntimeException(err, e);
/*     */     }
/*     */     finally
/*     */     {
/*  65 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean containsSensitiveWord(String content)
/*     */   {
/*  78 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/*  81 */       if ((content == null) || (content.isEmpty()))
/*     */       {
/*  83 */         return false;
/*     */       }
/*     */       
/*  86 */       for (int i = 0; i < content.length(); i++)
/*     */       {
/*  88 */         boolean ret = containsSensitiveWord(content, i, this._nodes);
/*  89 */         if (ret)
/*     */         {
/*  91 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*  97 */       this.lock.readLock().unlock();
/*     */     }
/*     */     
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   private boolean containsSensitiveWord(String content, int charIndex, Map<Character, Node> nodes)
/*     */   {
/* 105 */     if ((charIndex < 0) || (charIndex >= content.length()))
/*     */     {
/* 107 */       return false;
/*     */     }
/* 109 */     if (nodes == null)
/*     */     {
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     char c = content.charAt(charIndex);
/* 115 */     Node node = (Node)nodes.get(Character.valueOf(c));
/*     */     
/* 117 */     if (node == null)
/*     */     {
/* 119 */       return false;
/*     */     }
/* 121 */     if (node._isEnd)
/*     */     {
/* 123 */       return true;
/*     */     }
/*     */     
/* 126 */     return containsSensitiveWord(content, charIndex + 1, node._subNodes);
/*     */   }
/*     */   
/*     */   private void addSensitiveWord(String word)
/*     */   {
/* 131 */     if ((word == null) || (word.isEmpty()))
/*     */     {
/* 133 */       return;
/*     */     }
/*     */     
/* 136 */     Node node = null;
/* 137 */     for (int i = 0; i < word.length(); i++)
/*     */     {
/* 139 */       char c = word.charAt(i);
/*     */       
/* 141 */       if (!Character.isIdentifierIgnorable(c))
/*     */       {
/*     */         Map<Character, Node> nodes;
/*     */         
/*     */ 
/*     */         Map<Character, Node> nodes;
/*     */         
/* 148 */         if (node == null)
/*     */         {
/* 150 */           nodes = this._nodes;
/*     */         }
/*     */         else
/*     */         {
/* 154 */           nodes = node._subNodes;
/*     */         }
/*     */         
/* 157 */         node = (Node)nodes.get(Character.valueOf(c));
/* 158 */         if (node == null)
/*     */         {
/* 160 */           node = new Node(null);
/* 161 */           nodes.put(Character.valueOf(c), node);
/*     */         }
/*     */       }
/*     */     }
/* 165 */     if (node != null)
/*     */     {
/* 167 */       node._isEnd = true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sensitive\main\SensitiveWordsChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */