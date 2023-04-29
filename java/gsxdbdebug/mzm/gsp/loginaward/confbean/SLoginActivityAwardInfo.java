/*    */ package mzm.gsp.loginaward.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SLoginActivityAwardInfo implements Marshal
/*    */ {
/*    */   public int sortId;
/*    */   public int loginDay;
/*    */   public int awardCfgId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.sortId = Integer.valueOf(rootElement.attributeValue("sortId")).intValue();
/* 16 */     this.loginDay = Integer.valueOf(rootElement.attributeValue("loginDay")).intValue();
/* 17 */     this.awardCfgId = Integer.valueOf(rootElement.attributeValue("awardCfgId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.sortId);
/* 23 */     _os_.marshal(this.loginDay);
/* 24 */     _os_.marshal(this.awardCfgId);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.sortId = _os_.unmarshal_int();
/* 31 */     this.loginDay = _os_.unmarshal_int();
/* 32 */     this.awardCfgId = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\confbean\SLoginActivityAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */