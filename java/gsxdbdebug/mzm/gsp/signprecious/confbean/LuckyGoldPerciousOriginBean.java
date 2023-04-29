/*    */ package mzm.gsp.signprecious.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class LuckyGoldPerciousOriginBean implements Marshal
/*    */ {
/*    */   public int lucky_gold_precious_cfg_id;
/*    */   public int box_award_type;
/*    */   public int cost_yuan_bao;
/*    */   public int rate;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.lucky_gold_precious_cfg_id = Integer.valueOf(rootElement.attributeValue("lucky_gold_precious_cfg_id")).intValue();
/* 17 */     this.box_award_type = Integer.valueOf(rootElement.attributeValue("box_award_type")).intValue();
/* 18 */     this.cost_yuan_bao = Integer.valueOf(rootElement.attributeValue("cost_yuan_bao")).intValue();
/* 19 */     this.rate = Integer.valueOf(rootElement.attributeValue("rate")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.lucky_gold_precious_cfg_id);
/* 25 */     _os_.marshal(this.box_award_type);
/* 26 */     _os_.marshal(this.cost_yuan_bao);
/* 27 */     _os_.marshal(this.rate);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.lucky_gold_precious_cfg_id = _os_.unmarshal_int();
/* 34 */     this.box_award_type = _os_.unmarshal_int();
/* 35 */     this.cost_yuan_bao = _os_.unmarshal_int();
/* 36 */     this.rate = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signprecious\confbean\LuckyGoldPerciousOriginBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */