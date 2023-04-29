/*    */ package mzm.gsp.feisheng.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SFeiShengFightInfo implements Marshal
/*    */ {
/*    */   public int fight_cfg_id;
/*    */   public int team_leader_award_id;
/*    */   public int team_member_award_id;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.fight_cfg_id = Integer.valueOf(rootElement.attributeValue("fight_cfg_id")).intValue();
/* 16 */     this.team_leader_award_id = Integer.valueOf(rootElement.attributeValue("team_leader_award_id")).intValue();
/* 17 */     this.team_member_award_id = Integer.valueOf(rootElement.attributeValue("team_member_award_id")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.fight_cfg_id);
/* 23 */     _os_.marshal(this.team_leader_award_id);
/* 24 */     _os_.marshal(this.team_member_award_id);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.fight_cfg_id = _os_.unmarshal_int();
/* 31 */     this.team_leader_award_id = _os_.unmarshal_int();
/* 32 */     this.team_member_award_id = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\confbean\SFeiShengFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */