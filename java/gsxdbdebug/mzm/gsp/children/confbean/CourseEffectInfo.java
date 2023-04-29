/*    */ package mzm.gsp.children.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class CourseEffectInfo implements Marshal
/*    */ {
/*    */   public int interestType;
/*    */   public int interestValue;
/*    */   public int critValue;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.interestType = Integer.valueOf(rootElement.attributeValue("interestType")).intValue();
/* 16 */     this.interestValue = Integer.valueOf(rootElement.attributeValue("interestValue")).intValue();
/* 17 */     this.critValue = Integer.valueOf(rootElement.attributeValue("critValue")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.interestType);
/* 23 */     _os_.marshal(this.interestValue);
/* 24 */     _os_.marshal(this.critValue);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.interestType = _os_.unmarshal_int();
/* 31 */     this.interestValue = _os_.unmarshal_int();
/* 32 */     this.critValue = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\CourseEffectInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */