/*    */ package mzm.gsp.loginaward.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SLoginSignActivityAwardInfo implements Marshal
/*    */ {
/*    */   public int sortId;
/*    */   public int awardCfgId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.sortId = Integer.valueOf(rootElement.attributeValue("sortId")).intValue();
/* 15 */     this.awardCfgId = Integer.valueOf(rootElement.attributeValue("awardCfgId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.sortId);
/* 21 */     _os_.marshal(this.awardCfgId);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.sortId = _os_.unmarshal_int();
/* 28 */     this.awardCfgId = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\confbean\SLoginSignActivityAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */