/*    */ package mzm.gsp.skill.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class EffectPlayData implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int lastTime;
/*    */   public int attackEffect;
/* 11 */   public ArrayList<BeAttackedBean> beAttackedList = new ArrayList();
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.lastTime = Integer.valueOf(rootElement.attributeValue("lastTime")).intValue();
/* 16 */     this.attackEffect = Integer.valueOf(rootElement.attributeValue("attackEffect")).intValue();
/*    */     
/* 18 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "beAttackedList");
/* 19 */     if (collectionElement == null)
/*    */     {
/* 21 */       throw new RuntimeException("collection type element does not find");
/*    */     }
/*    */     
/* 24 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 25 */     int _len = _nodeList.size();
/* 26 */     for (int i = 0; i < _len; i++)
/*    */     {
/* 28 */       Element elem = (Element)_nodeList.get(i);
/* 29 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.BeAttackedBean"))
/*    */       {
/*    */         BeAttackedBean _v_;
/*    */         
/*    */ 
/*    */         try
/*    */         {
/* 36 */           _v_ = new BeAttackedBean();
/* 37 */           _v_.loadFromXml(elem);
/*    */         }
/*    */         catch (Exception e)
/*    */         {
/*    */           continue;
/*    */         }
/*    */         
/* 44 */         this.beAttackedList.add(_v_);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 51 */     _os_.marshal(this.lastTime);
/* 52 */     _os_.marshal(this.attackEffect);
/* 53 */     _os_.compact_uint32(this.beAttackedList.size());
/* 54 */     for (BeAttackedBean _v_ : this.beAttackedList)
/*    */     {
/* 56 */       _os_.marshal(_v_);
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 63 */     this.lastTime = _os_.unmarshal_int();
/* 64 */     this.attackEffect = _os_.unmarshal_int();
/* 65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/*    */ 
/* 68 */       BeAttackedBean _v_ = new BeAttackedBean();
/* 69 */       _v_.unmarshal(_os_);
/* 70 */       this.beAttackedList.add(_v_);
/*    */     }
/* 72 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\EffectPlayData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */