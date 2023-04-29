/*    */ package mzm.gsp.map;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.map.main.PGetMonsterReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetMonsterLocationReq
/*    */   extends __CGetMonsterLocationReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590860;
/*    */   public int monstercfgid;
/*    */   public int targetmapid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     new PGetMonsterReq(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590860;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetMonsterLocationReq() {}
/*    */   
/*    */ 
/*    */   public CGetMonsterLocationReq(int _monstercfgid_, int _targetmapid_)
/*    */   {
/* 37 */     this.monstercfgid = _monstercfgid_;
/* 38 */     this.targetmapid = _targetmapid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.monstercfgid);
/* 47 */     _os_.marshal(this.targetmapid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.monstercfgid = _os_.unmarshal_int();
/* 53 */     this.targetmapid = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof CGetMonsterLocationReq)) {
/* 63 */       CGetMonsterLocationReq _o_ = (CGetMonsterLocationReq)_o1_;
/* 64 */       if (this.monstercfgid != _o_.monstercfgid) return false;
/* 65 */       if (this.targetmapid != _o_.targetmapid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.monstercfgid;
/* 74 */     _h_ += this.targetmapid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.monstercfgid).append(",");
/* 82 */     _sb_.append(this.targetmapid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetMonsterLocationReq _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.monstercfgid - _o_.monstercfgid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.targetmapid - _o_.targetmapid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\CGetMonsterLocationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */