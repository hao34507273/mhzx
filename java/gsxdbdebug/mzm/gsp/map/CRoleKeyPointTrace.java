/*    */ package mzm.gsp.map;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CRoleKeyPointTrace
/*    */   extends __CRoleKeyPointTrace__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590857;
/*    */   public int mapid;
/*    */   public LinkedList<Location> keypoints;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 26 */     return 12590857;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CRoleKeyPointTrace()
/*    */   {
/* 33 */     this.keypoints = new LinkedList();
/*    */   }
/*    */   
/*    */   public CRoleKeyPointTrace(int _mapid_, LinkedList<Location> _keypoints_) {
/* 37 */     this.mapid = _mapid_;
/* 38 */     this.keypoints = _keypoints_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     for (Location _v_ : this.keypoints)
/* 43 */       if (!_v_._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.mapid);
/* 49 */     _os_.compact_uint32(this.keypoints.size());
/* 50 */     for (Location _v_ : this.keypoints) {
/* 51 */       _os_.marshal(_v_);
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.mapid = _os_.unmarshal_int();
/* 58 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 59 */       Location _v_ = new Location();
/* 60 */       _v_.unmarshal(_os_);
/* 61 */       this.keypoints.add(_v_);
/*    */     }
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof CRoleKeyPointTrace)) {
/* 72 */       CRoleKeyPointTrace _o_ = (CRoleKeyPointTrace)_o1_;
/* 73 */       if (this.mapid != _o_.mapid) return false;
/* 74 */       if (!this.keypoints.equals(_o_.keypoints)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.mapid;
/* 83 */     _h_ += this.keypoints.hashCode();
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.mapid).append(",");
/* 91 */     _sb_.append(this.keypoints).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\CRoleKeyPointTrace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */