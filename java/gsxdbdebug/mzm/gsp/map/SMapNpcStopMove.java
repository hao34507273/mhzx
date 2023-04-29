/*    */ package mzm.gsp.map;
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
/*    */ public class SMapNpcStopMove
/*    */   extends __SMapNpcStopMove__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590894;
/*    */   public int npcid;
/*    */   public Location currentloc;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590894;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SMapNpcStopMove()
/*    */   {
/* 34 */     this.currentloc = new Location();
/*    */   }
/*    */   
/*    */   public SMapNpcStopMove(int _npcid_, Location _currentloc_) {
/* 38 */     this.npcid = _npcid_;
/* 39 */     this.currentloc = _currentloc_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.currentloc._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.npcid);
/* 49 */     _os_.marshal(this.currentloc);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.npcid = _os_.unmarshal_int();
/* 55 */     this.currentloc.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SMapNpcStopMove)) {
/* 65 */       SMapNpcStopMove _o_ = (SMapNpcStopMove)_o1_;
/* 66 */       if (this.npcid != _o_.npcid) return false;
/* 67 */       if (!this.currentloc.equals(_o_.currentloc)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.npcid;
/* 76 */     _h_ += this.currentloc.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.npcid).append(",");
/* 84 */     _sb_.append(this.currentloc).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SMapNpcStopMove _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.npcid - _o_.npcid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.currentloc.compareTo(_o_.currentloc);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SMapNpcStopMove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */