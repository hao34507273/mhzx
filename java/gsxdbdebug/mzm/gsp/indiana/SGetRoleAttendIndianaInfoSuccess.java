/*    */ package mzm.gsp.indiana;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SGetRoleAttendIndianaInfoSuccess
/*    */   extends __SGetRoleAttendIndianaInfoSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12629008;
/*    */   public int activity_cfg_id;
/*    */   public int turn;
/*    */   public HashSet<Integer> attend_sortids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12629008;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetRoleAttendIndianaInfoSuccess()
/*    */   {
/* 35 */     this.attend_sortids = new HashSet();
/*    */   }
/*    */   
/*    */   public SGetRoleAttendIndianaInfoSuccess(int _activity_cfg_id_, int _turn_, HashSet<Integer> _attend_sortids_) {
/* 39 */     this.activity_cfg_id = _activity_cfg_id_;
/* 40 */     this.turn = _turn_;
/* 41 */     this.attend_sortids = _attend_sortids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.activity_cfg_id);
/* 50 */     _os_.marshal(this.turn);
/* 51 */     _os_.compact_uint32(this.attend_sortids.size());
/* 52 */     for (Integer _v_ : this.attend_sortids) {
/* 53 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 60 */     this.turn = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       int _v_ = _os_.unmarshal_int();
/* 64 */       this.attend_sortids.add(Integer.valueOf(_v_));
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SGetRoleAttendIndianaInfoSuccess)) {
/* 75 */       SGetRoleAttendIndianaInfoSuccess _o_ = (SGetRoleAttendIndianaInfoSuccess)_o1_;
/* 76 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 77 */       if (this.turn != _o_.turn) return false;
/* 78 */       if (!this.attend_sortids.equals(_o_.attend_sortids)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.activity_cfg_id;
/* 87 */     _h_ += this.turn;
/* 88 */     _h_ += this.attend_sortids.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.activity_cfg_id).append(",");
/* 96 */     _sb_.append(this.turn).append(",");
/* 97 */     _sb_.append(this.attend_sortids).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\SGetRoleAttendIndianaInfoSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */