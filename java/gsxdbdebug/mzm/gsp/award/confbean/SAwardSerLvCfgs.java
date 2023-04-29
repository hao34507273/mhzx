/*    */ package mzm.gsp.award.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SAwardSerLvCfgs implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*  9 */   public ArrayList<ServerLevelModify> awardServerLevels = new ArrayList();
/*    */   
/*    */ 
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "awardServerLevels");
/* 15 */     if (collectionElement == null)
/*    */     {
/* 17 */       throw new RuntimeException("collection type element does not find");
/*    */     }
/*    */     
/* 20 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 21 */     int _len = _nodeList.size();
/* 22 */     for (int i = 0; i < _len; i++)
/*    */     {
/* 24 */       Element elem = (Element)_nodeList.get(i);
/* 25 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.ServerLevelModify"))
/*    */       {
/*    */         ServerLevelModify _v_;
/*    */         
/*    */ 
/*    */         try
/*    */         {
/* 32 */           _v_ = new ServerLevelModify();
/* 33 */           _v_.loadFromXml(elem);
/*    */         }
/*    */         catch (Exception e)
/*    */         {
/*    */           continue;
/*    */         }
/*    */         
/* 40 */         this.awardServerLevels.add(_v_);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 47 */     _os_.compact_uint32(this.awardServerLevels.size());
/* 48 */     for (ServerLevelModify _v_ : this.awardServerLevels)
/*    */     {
/* 50 */       _os_.marshal(_v_);
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/*    */ 
/* 60 */       ServerLevelModify _v_ = new ServerLevelModify();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.awardServerLevels.add(_v_);
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\SAwardSerLvCfgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */