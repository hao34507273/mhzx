/*    */ package mzm.gsp.activity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SHuSongRes
/*    */   extends __SHuSongRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587552;
/*    */   public int husongcfgid;
/*    */   public int husong_couple_npc_cfgid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12587552;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SHuSongRes() {}
/*    */   
/*    */ 
/*    */   public SHuSongRes(int _husongcfgid_, int _husong_couple_npc_cfgid_)
/*    */   {
/* 37 */     this.husongcfgid = _husongcfgid_;
/* 38 */     this.husong_couple_npc_cfgid = _husong_couple_npc_cfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.husongcfgid);
/* 47 */     _os_.marshal(this.husong_couple_npc_cfgid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.husongcfgid = _os_.unmarshal_int();
/* 53 */     this.husong_couple_npc_cfgid = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SHuSongRes)) {
/* 63 */       SHuSongRes _o_ = (SHuSongRes)_o1_;
/* 64 */       if (this.husongcfgid != _o_.husongcfgid) return false;
/* 65 */       if (this.husong_couple_npc_cfgid != _o_.husong_couple_npc_cfgid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.husongcfgid;
/* 74 */     _h_ += this.husong_couple_npc_cfgid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.husongcfgid).append(",");
/* 82 */     _sb_.append(this.husong_couple_npc_cfgid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SHuSongRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.husongcfgid - _o_.husongcfgid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.husong_couple_npc_cfgid - _o_.husong_couple_npc_cfgid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SHuSongRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */