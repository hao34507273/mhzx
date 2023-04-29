/*    */ package mzm.gsp.fight;
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
/*    */ public class SFighterOnlineBrd
/*    */   extends __SFighterOnlineBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594181;
/*    */   public static final int OFFLINE = 0;
/*    */   public static final int ONLINE = 1;
/*    */   public int fighterid;
/*    */   public int status;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594181;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SFighterOnlineBrd() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SFighterOnlineBrd(int _fighterid_, int _status_)
/*    */   {
/* 40 */     this.fighterid = _fighterid_;
/* 41 */     this.status = _status_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.fighterid);
/* 50 */     _os_.marshal(this.status);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.fighterid = _os_.unmarshal_int();
/* 56 */     this.status = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SFighterOnlineBrd)) {
/* 66 */       SFighterOnlineBrd _o_ = (SFighterOnlineBrd)_o1_;
/* 67 */       if (this.fighterid != _o_.fighterid) return false;
/* 68 */       if (this.status != _o_.status) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.fighterid;
/* 77 */     _h_ += this.status;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.fighterid).append(",");
/* 85 */     _sb_.append(this.status).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SFighterOnlineBrd _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.fighterid - _o_.fighterid;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.status - _o_.status;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SFighterOnlineBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */