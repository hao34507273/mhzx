/*    */ package mzm.gsp.pet.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class MinmumGuaranteeBean implements Marshal
/*    */ {
/*    */   public int need_low_minimum_guarantee_item_num;
/*    */   public int need_high_minimum_guarantee_item_num;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.need_low_minimum_guarantee_item_num = Integer.valueOf(rootElement.attributeValue("need_low_minimum_guarantee_item_num")).intValue();
/* 15 */     this.need_high_minimum_guarantee_item_num = Integer.valueOf(rootElement.attributeValue("need_high_minimum_guarantee_item_num")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.need_low_minimum_guarantee_item_num);
/* 21 */     _os_.marshal(this.need_high_minimum_guarantee_item_num);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.need_low_minimum_guarantee_item_num = _os_.unmarshal_int();
/* 28 */     this.need_high_minimum_guarantee_item_num = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\confbean\MinmumGuaranteeBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */