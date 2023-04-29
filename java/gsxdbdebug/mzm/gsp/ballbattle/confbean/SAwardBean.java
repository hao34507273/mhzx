/*    */ package mzm.gsp.ballbattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SAwardBean implements Marshal
/*    */ {
/*    */   public int lowestAwardPosition;
/*    */   public int awardId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.lowestAwardPosition = Integer.valueOf(rootElement.attributeValue("lowestAwardPosition")).intValue();
/* 15 */     this.awardId = Integer.valueOf(rootElement.attributeValue("awardId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.lowestAwardPosition);
/* 21 */     _os_.marshal(this.awardId);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.lowestAwardPosition = _os_.unmarshal_int();
/* 28 */     this.awardId = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\confbean\SAwardBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */