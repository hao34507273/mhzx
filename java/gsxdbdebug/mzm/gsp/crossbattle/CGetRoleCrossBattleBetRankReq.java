/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.bet.PCGetRoleCrossBattleBetRank;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetRoleCrossBattleBetRankReq
/*    */   extends __CGetRoleCrossBattleBetRankReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617093;
/*    */   public int rank_type;
/*    */   public int activity_cfg_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid < 0L)
/* 21 */       return;
/* 22 */     Role.addRoleProcedure(roleid, new PCGetRoleCrossBattleBetRank(roleid, this.rank_type, this.activity_cfg_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12617093;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetRoleCrossBattleBetRankReq() {}
/*    */   
/*    */ 
/*    */   public CGetRoleCrossBattleBetRankReq(int _rank_type_, int _activity_cfg_id_)
/*    */   {
/* 40 */     this.rank_type = _rank_type_;
/* 41 */     this.activity_cfg_id = _activity_cfg_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.rank_type);
/* 50 */     _os_.marshal(this.activity_cfg_id);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.rank_type = _os_.unmarshal_int();
/* 56 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CGetRoleCrossBattleBetRankReq)) {
/* 66 */       CGetRoleCrossBattleBetRankReq _o_ = (CGetRoleCrossBattleBetRankReq)_o1_;
/* 67 */       if (this.rank_type != _o_.rank_type) return false;
/* 68 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.rank_type;
/* 77 */     _h_ += this.activity_cfg_id;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.rank_type).append(",");
/* 85 */     _sb_.append(this.activity_cfg_id).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetRoleCrossBattleBetRankReq _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.rank_type - _o_.rank_type;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CGetRoleCrossBattleBetRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */