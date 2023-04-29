/*    */ package mzm.gsp.qingfu.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class MonthCardActivityPhaseInfo implements Marshal
/*    */ {
/*    */   public int present_award_cfg_id;
/*    */   public int daily_award_cfg_id;
/*    */   public int serviceId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.present_award_cfg_id = Integer.valueOf(rootElement.attributeValue("present_award_cfg_id")).intValue();
/* 16 */     this.daily_award_cfg_id = Integer.valueOf(rootElement.attributeValue("daily_award_cfg_id")).intValue();
/* 17 */     this.serviceId = Integer.valueOf(rootElement.attributeValue("serviceId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.present_award_cfg_id);
/* 23 */     _os_.marshal(this.daily_award_cfg_id);
/* 24 */     _os_.marshal(this.serviceId);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.present_award_cfg_id = _os_.unmarshal_int();
/* 31 */     this.daily_award_cfg_id = _os_.unmarshal_int();
/* 32 */     this.serviceId = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\confbean\MonthCardActivityPhaseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */