/*    */ package mzm.gsp.children.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class InterestEffectInfo implements Marshal
/*    */ {
/*    */   public int interestType;
/*    */   public int interestValue;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.interestType = Integer.valueOf(rootElement.attributeValue("interestType")).intValue();
/* 15 */     this.interestValue = Integer.valueOf(rootElement.attributeValue("interestValue")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.interestType);
/* 21 */     _os_.marshal(this.interestValue);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.interestType = _os_.unmarshal_int();
/* 28 */     this.interestValue = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\InterestEffectInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */