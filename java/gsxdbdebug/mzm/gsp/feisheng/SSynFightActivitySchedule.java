/*    */ package mzm.gsp.feisheng;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSynFightActivitySchedule
/*    */   extends __SSynFightActivitySchedule__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12614153;
/*    */   public int activity_cfg_id;
/*    */   public ArrayList<Integer> complete_sortids;
/*    */   public int daily_get_team_member_award_times;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12614153;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSynFightActivitySchedule()
/*    */   {
/* 35 */     this.complete_sortids = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSynFightActivitySchedule(int _activity_cfg_id_, ArrayList<Integer> _complete_sortids_, int _daily_get_team_member_award_times_) {
/* 39 */     this.activity_cfg_id = _activity_cfg_id_;
/* 40 */     this.complete_sortids = _complete_sortids_;
/* 41 */     this.daily_get_team_member_award_times = _daily_get_team_member_award_times_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.activity_cfg_id);
/* 50 */     _os_.compact_uint32(this.complete_sortids.size());
/* 51 */     for (Integer _v_ : this.complete_sortids) {
/* 52 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 54 */     _os_.marshal(this.daily_get_team_member_award_times);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 62 */       int _v_ = _os_.unmarshal_int();
/* 63 */       this.complete_sortids.add(Integer.valueOf(_v_));
/*    */     }
/* 65 */     this.daily_get_team_member_award_times = _os_.unmarshal_int();
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SSynFightActivitySchedule)) {
/* 75 */       SSynFightActivitySchedule _o_ = (SSynFightActivitySchedule)_o1_;
/* 76 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 77 */       if (!this.complete_sortids.equals(_o_.complete_sortids)) return false;
/* 78 */       if (this.daily_get_team_member_award_times != _o_.daily_get_team_member_award_times) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.activity_cfg_id;
/* 87 */     _h_ += this.complete_sortids.hashCode();
/* 88 */     _h_ += this.daily_get_team_member_award_times;
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.activity_cfg_id).append(",");
/* 96 */     _sb_.append(this.complete_sortids).append(",");
/* 97 */     _sb_.append(this.daily_get_team_member_award_times).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\SSynFightActivitySchedule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */