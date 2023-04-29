/*    */ package mzm.gsp.activity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.husong.main.PCHuSongReq;
/*    */ 
/*    */ 
/*    */ public class CHuSongReq
/*    */   extends __CHuSongReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587549;
/*    */   public static final int HU_SONG_NORMAL_SREVICEID = 150205052;
/*    */   public static final int HU_SONG_SPECIAL_SREVICEID = 150205053;
/*    */   public static final int HU_SONG_DEC_SREVICEID = 150205054;
/*    */   public int husongtype;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PCHuSongReq(roleid, this.husongtype));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12587549;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CHuSongReq() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CHuSongReq(int _husongtype_)
/*    */   {
/* 42 */     this.husongtype = _husongtype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.husongtype);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.husongtype = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CHuSongReq)) {
/* 65 */       CHuSongReq _o_ = (CHuSongReq)_o1_;
/* 66 */       if (this.husongtype != _o_.husongtype) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.husongtype;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.husongtype).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CHuSongReq _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = this.husongtype - _o_.husongtype;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\CHuSongReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */