/*    */ package mzm.gsp.qingfu.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class RMBGiftBagTierInfo implements Marshal
/*    */ {
/*    */   public int buy_max_times;
/*    */   public int award_cfg_id;
/*    */   public int product_service_id;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.buy_max_times = Integer.valueOf(rootElement.attributeValue("buy_max_times")).intValue();
/* 16 */     this.award_cfg_id = Integer.valueOf(rootElement.attributeValue("award_cfg_id")).intValue();
/* 17 */     this.product_service_id = Integer.valueOf(rootElement.attributeValue("product_service_id")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.buy_max_times);
/* 23 */     _os_.marshal(this.award_cfg_id);
/* 24 */     _os_.marshal(this.product_service_id);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.buy_max_times = _os_.unmarshal_int();
/* 31 */     this.award_cfg_id = _os_.unmarshal_int();
/* 32 */     this.product_service_id = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\confbean\RMBGiftBagTierInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */