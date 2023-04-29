/*    */ package mzm.gsp.signprecious.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class LuckyGoldPerciousBean implements Marshal
/*    */ {
/*    */   public int lucky_gold_precious_cfg_id;
/*    */   public int box_award_type;
/*    */   public int cost_yuan_bao;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.lucky_gold_precious_cfg_id = Integer.valueOf(rootElement.attributeValue("lucky_gold_precious_cfg_id")).intValue();
/* 16 */     this.box_award_type = Integer.valueOf(rootElement.attributeValue("box_award_type")).intValue();
/* 17 */     this.cost_yuan_bao = Integer.valueOf(rootElement.attributeValue("cost_yuan_bao")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.lucky_gold_precious_cfg_id);
/* 23 */     _os_.marshal(this.box_award_type);
/* 24 */     _os_.marshal(this.cost_yuan_bao);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.lucky_gold_precious_cfg_id = _os_.unmarshal_int();
/* 31 */     this.box_award_type = _os_.unmarshal_int();
/* 32 */     this.cost_yuan_bao = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signprecious\confbean\LuckyGoldPerciousBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */