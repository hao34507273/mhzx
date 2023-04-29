/*    */ package mzm.gsp.task.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SSubSet implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int refreshPercent;
/*    */   public int refreshCountLimit;
/*    */   public int levelMin;
/*    */   public int levelMax;
/* 13 */   public ArrayList<Integer> taskIds = new ArrayList();
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 17 */     this.refreshPercent = Integer.valueOf(rootElement.attributeValue("refreshPercent")).intValue();
/* 18 */     this.refreshCountLimit = Integer.valueOf(rootElement.attributeValue("refreshCountLimit")).intValue();
/* 19 */     this.levelMin = Integer.valueOf(rootElement.attributeValue("levelMin")).intValue();
/* 20 */     this.levelMax = Integer.valueOf(rootElement.attributeValue("levelMax")).intValue();
/*    */     
/* 22 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "taskIds");
/* 23 */     if (collectionElement == null)
/*    */     {
/* 25 */       throw new RuntimeException("collection type element does not find");
/*    */     }
/*    */     
/* 28 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 29 */     int _len = _nodeList.size();
/* 30 */     for (int i = 0; i < _len; i++)
/*    */     {
/* 32 */       Element elem = (Element)_nodeList.get(i);
/* 33 */       if (elem.getName().equalsIgnoreCase("int"))
/*    */       {
/*    */         int _v_;
/*    */         
/*    */ 
/*    */         try
/*    */         {
/* 40 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*    */         }
/*    */         catch (Exception e)
/*    */         {
/*    */           continue;
/*    */         }
/*    */         
/* 47 */         this.taskIds.add(Integer.valueOf(_v_));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 54 */     _os_.marshal(this.refreshPercent);
/* 55 */     _os_.marshal(this.refreshCountLimit);
/* 56 */     _os_.marshal(this.levelMin);
/* 57 */     _os_.marshal(this.levelMax);
/* 58 */     _os_.compact_uint32(this.taskIds.size());
/* 59 */     for (Integer _v_ : this.taskIds)
/*    */     {
/* 61 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 68 */     this.refreshPercent = _os_.unmarshal_int();
/* 69 */     this.refreshCountLimit = _os_.unmarshal_int();
/* 70 */     this.levelMin = _os_.unmarshal_int();
/* 71 */     this.levelMax = _os_.unmarshal_int();
/* 72 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/*    */ 
/* 75 */       int _v_ = _os_.unmarshal_int();
/* 76 */       this.taskIds.add(Integer.valueOf(_v_));
/*    */     }
/* 78 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\confbean\SSubSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */