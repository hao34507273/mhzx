/*    */ package mzm.gsp.activity3.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class BackGameActivitySignAward implements Marshal
/*    */ {
/*    */   public int awardId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 13 */     this.awardId = Integer.valueOf(rootElement.attributeValue("awardId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 18 */     _os_.marshal(this.awardId);
/* 19 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 24 */     this.awardId = _os_.unmarshal_int();
/* 25 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\BackGameActivitySignAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */