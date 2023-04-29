/*    */ package mzm.gsp.loginaward.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SLoginSumActivityAwardInfo implements Marshal
/*    */ {
/*    */   public int sortId;
/*    */   public int loginSum;
/*    */   public int awardCfgId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.sortId = Integer.valueOf(rootElement.attributeValue("sortId")).intValue();
/* 16 */     this.loginSum = Integer.valueOf(rootElement.attributeValue("loginSum")).intValue();
/* 17 */     this.awardCfgId = Integer.valueOf(rootElement.attributeValue("awardCfgId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.sortId);
/* 23 */     _os_.marshal(this.loginSum);
/* 24 */     _os_.marshal(this.awardCfgId);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.sortId = _os_.unmarshal_int();
/* 31 */     this.loginSum = _os_.unmarshal_int();
/* 32 */     this.awardCfgId = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\confbean\SLoginSumActivityAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */