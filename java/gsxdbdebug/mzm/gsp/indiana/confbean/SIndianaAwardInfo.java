/*    */ package mzm.gsp.indiana.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SIndianaAwardInfo implements Marshal
/*    */ {
/*    */   public int cost_money_type;
/*    */   public int cost_money_num;
/*    */   public int special_number_need_yuanbao_num;
/*    */   public int attend_fix_award_id;
/*    */   public int fix_award_id;
/*    */   public int init_award_num;
/*    */   public int extra_award_need_num;
/*    */   public boolean need_log;
/*    */   public boolean need_bulletin;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 21 */     this.cost_money_type = Integer.valueOf(rootElement.attributeValue("cost_money_type")).intValue();
/* 22 */     this.cost_money_num = Integer.valueOf(rootElement.attributeValue("cost_money_num")).intValue();
/* 23 */     this.special_number_need_yuanbao_num = Integer.valueOf(rootElement.attributeValue("special_number_need_yuanbao_num")).intValue();
/* 24 */     this.attend_fix_award_id = Integer.valueOf(rootElement.attributeValue("attend_fix_award_id")).intValue();
/* 25 */     this.fix_award_id = Integer.valueOf(rootElement.attributeValue("fix_award_id")).intValue();
/* 26 */     this.init_award_num = Integer.valueOf(rootElement.attributeValue("init_award_num")).intValue();
/* 27 */     this.extra_award_need_num = Integer.valueOf(rootElement.attributeValue("extra_award_need_num")).intValue();
/* 28 */     this.need_log = Boolean.valueOf(rootElement.attributeValue("need_log")).booleanValue();
/* 29 */     this.need_bulletin = Boolean.valueOf(rootElement.attributeValue("need_bulletin")).booleanValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 34 */     _os_.marshal(this.cost_money_type);
/* 35 */     _os_.marshal(this.cost_money_num);
/* 36 */     _os_.marshal(this.special_number_need_yuanbao_num);
/* 37 */     _os_.marshal(this.attend_fix_award_id);
/* 38 */     _os_.marshal(this.fix_award_id);
/* 39 */     _os_.marshal(this.init_award_num);
/* 40 */     _os_.marshal(this.extra_award_need_num);
/* 41 */     _os_.marshal(this.need_log);
/* 42 */     _os_.marshal(this.need_bulletin);
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 48 */     this.cost_money_type = _os_.unmarshal_int();
/* 49 */     this.cost_money_num = _os_.unmarshal_int();
/* 50 */     this.special_number_need_yuanbao_num = _os_.unmarshal_int();
/* 51 */     this.attend_fix_award_id = _os_.unmarshal_int();
/* 52 */     this.fix_award_id = _os_.unmarshal_int();
/* 53 */     this.init_award_num = _os_.unmarshal_int();
/* 54 */     this.extra_award_need_num = _os_.unmarshal_int();
/* 55 */     this.need_log = _os_.unmarshal_boolean();
/* 56 */     this.need_bulletin = _os_.unmarshal_boolean();
/* 57 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\confbean\SIndianaAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */