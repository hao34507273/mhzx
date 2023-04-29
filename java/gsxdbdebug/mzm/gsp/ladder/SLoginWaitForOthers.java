/*    */ package mzm.gsp.ladder;
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
/*    */ 
/*    */ public class SLoginWaitForOthers
/*    */   extends __SLoginWaitForOthers__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12607260;
/*    */   public ArrayList<WaitRoleInfo> waitroleinfos;
/*    */   public int ret;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12607260;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SLoginWaitForOthers()
/*    */   {
/* 34 */     this.waitroleinfos = new ArrayList();
/*    */   }
/*    */   
/*    */   public SLoginWaitForOthers(ArrayList<WaitRoleInfo> _waitroleinfos_, int _ret_) {
/* 38 */     this.waitroleinfos = _waitroleinfos_;
/* 39 */     this.ret = _ret_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (WaitRoleInfo _v_ : this.waitroleinfos)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.compact_uint32(this.waitroleinfos.size());
/* 50 */     for (WaitRoleInfo _v_ : this.waitroleinfos) {
/* 51 */       _os_.marshal(_v_);
/*    */     }
/* 53 */     _os_.marshal(this.ret);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 59 */       WaitRoleInfo _v_ = new WaitRoleInfo();
/* 60 */       _v_.unmarshal(_os_);
/* 61 */       this.waitroleinfos.add(_v_);
/*    */     }
/* 63 */     this.ret = _os_.unmarshal_int();
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SLoginWaitForOthers)) {
/* 73 */       SLoginWaitForOthers _o_ = (SLoginWaitForOthers)_o1_;
/* 74 */       if (!this.waitroleinfos.equals(_o_.waitroleinfos)) return false;
/* 75 */       if (this.ret != _o_.ret) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.waitroleinfos.hashCode();
/* 84 */     _h_ += this.ret;
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.waitroleinfos).append(",");
/* 92 */     _sb_.append(this.ret).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\SLoginWaitForOthers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */