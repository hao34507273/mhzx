/*    */ package mzm.gsp.qingfu.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SLevelGrowthFundActivityAwardInfo implements Marshal
/*    */ {
/*    */   public int level_cond;
/*    */   public int award_cfg_id;
/*    */   public int sort_id;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.level_cond = Integer.valueOf(rootElement.attributeValue("level_cond")).intValue();
/* 16 */     this.award_cfg_id = Integer.valueOf(rootElement.attributeValue("award_cfg_id")).intValue();
/* 17 */     this.sort_id = Integer.valueOf(rootElement.attributeValue("sort_id")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.level_cond);
/* 23 */     _os_.marshal(this.award_cfg_id);
/* 24 */     _os_.marshal(this.sort_id);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.level_cond = _os_.unmarshal_int();
/* 31 */     this.award_cfg_id = _os_.unmarshal_int();
/* 32 */     this.sort_id = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\confbean\SLevelGrowthFundActivityAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */