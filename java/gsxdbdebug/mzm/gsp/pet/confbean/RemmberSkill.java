/*    */ package mzm.gsp.pet.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class RemmberSkill implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int id;
/*    */   public int index;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 13 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/* 14 */     this.index = Integer.valueOf(rootElement.attributeValue("index")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 19 */     _os_.marshal(this.id);
/* 20 */     _os_.marshal(this.index);
/* 21 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 26 */     this.id = _os_.unmarshal_int();
/* 27 */     this.index = _os_.unmarshal_int();
/* 28 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\confbean\RemmberSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */