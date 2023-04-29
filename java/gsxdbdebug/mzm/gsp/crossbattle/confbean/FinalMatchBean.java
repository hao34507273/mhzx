/*    */ package mzm.gsp.crossbattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class FinalMatchBean implements Marshal
/*    */ {
/*    */   public int corps_a_fight_zone;
/*    */   public int corps_b_fight_zone;
/*    */   public int corps_a_zone_rank;
/*    */   public int corps_b_zone_rank;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.corps_a_fight_zone = Integer.valueOf(rootElement.attributeValue("corps_a_fight_zone")).intValue();
/* 17 */     this.corps_b_fight_zone = Integer.valueOf(rootElement.attributeValue("corps_b_fight_zone")).intValue();
/* 18 */     this.corps_a_zone_rank = Integer.valueOf(rootElement.attributeValue("corps_a_zone_rank")).intValue();
/* 19 */     this.corps_b_zone_rank = Integer.valueOf(rootElement.attributeValue("corps_b_zone_rank")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.corps_a_fight_zone);
/* 25 */     _os_.marshal(this.corps_b_fight_zone);
/* 26 */     _os_.marshal(this.corps_a_zone_rank);
/* 27 */     _os_.marshal(this.corps_b_zone_rank);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.corps_a_fight_zone = _os_.unmarshal_int();
/* 34 */     this.corps_b_fight_zone = _os_.unmarshal_int();
/* 35 */     this.corps_a_zone_rank = _os_.unmarshal_int();
/* 36 */     this.corps_b_zone_rank = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\FinalMatchBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */