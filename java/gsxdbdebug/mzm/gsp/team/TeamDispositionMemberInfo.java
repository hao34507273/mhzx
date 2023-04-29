/*    */ package mzm.gsp.team;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.pubdata.ModelInfo;
/*    */ 
/*    */ public class TeamDispositionMemberInfo
/*    */   implements Marshal
/*    */ {
/*    */   public static final int DT_TEAM_MEMBER = 0;
/*    */   public static final int DT_PARTNER = 1;
/*    */   public long teamdispositionmember_id;
/*    */   public int dispositionmembertype;
/*    */   public ModelInfo model;
/*    */   
/*    */   public TeamDispositionMemberInfo()
/*    */   {
/* 19 */     this.model = new ModelInfo();
/*    */   }
/*    */   
/*    */   public TeamDispositionMemberInfo(long _teamdispositionmember_id_, int _dispositionmembertype_, ModelInfo _model_) {
/* 23 */     this.teamdispositionmember_id = _teamdispositionmember_id_;
/* 24 */     this.dispositionmembertype = _dispositionmembertype_;
/* 25 */     this.model = _model_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     if (!this.model._validator_()) return false;
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.teamdispositionmember_id);
/* 35 */     _os_.marshal(this.dispositionmembertype);
/* 36 */     _os_.marshal(this.model);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 41 */     this.teamdispositionmember_id = _os_.unmarshal_long();
/* 42 */     this.dispositionmembertype = _os_.unmarshal_int();
/* 43 */     this.model.unmarshal(_os_);
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 48 */     if (_o1_ == this) return true;
/* 49 */     if ((_o1_ instanceof TeamDispositionMemberInfo)) {
/* 50 */       TeamDispositionMemberInfo _o_ = (TeamDispositionMemberInfo)_o1_;
/* 51 */       if (this.teamdispositionmember_id != _o_.teamdispositionmember_id) return false;
/* 52 */       if (this.dispositionmembertype != _o_.dispositionmembertype) return false;
/* 53 */       if (!this.model.equals(_o_.model)) return false;
/* 54 */       return true;
/*    */     }
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 60 */     int _h_ = 0;
/* 61 */     _h_ += (int)this.teamdispositionmember_id;
/* 62 */     _h_ += this.dispositionmembertype;
/* 63 */     _h_ += this.model.hashCode();
/* 64 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 68 */     StringBuilder _sb_ = new StringBuilder();
/* 69 */     _sb_.append("(");
/* 70 */     _sb_.append(this.teamdispositionmember_id).append(",");
/* 71 */     _sb_.append(this.dispositionmembertype).append(",");
/* 72 */     _sb_.append(this.model).append(",");
/* 73 */     _sb_.append(")");
/* 74 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\TeamDispositionMemberInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */