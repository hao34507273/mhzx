/*    */ package mzm.gsp.instance;
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
/*    */ public class SSynSingleInstanceInfo
/*    */   extends __SSynSingleInstanceInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12591386;
/*    */   public ArrayList<SingleInfo> singleinstanceinfo;
/*    */   public int singlefailtime;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12591386;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynSingleInstanceInfo()
/*    */   {
/* 34 */     this.singleinstanceinfo = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSynSingleInstanceInfo(ArrayList<SingleInfo> _singleinstanceinfo_, int _singlefailtime_) {
/* 38 */     this.singleinstanceinfo = _singleinstanceinfo_;
/* 39 */     this.singlefailtime = _singlefailtime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (SingleInfo _v_ : this.singleinstanceinfo)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.compact_uint32(this.singleinstanceinfo.size());
/* 50 */     for (SingleInfo _v_ : this.singleinstanceinfo) {
/* 51 */       _os_.marshal(_v_);
/*    */     }
/* 53 */     _os_.marshal(this.singlefailtime);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 59 */       SingleInfo _v_ = new SingleInfo();
/* 60 */       _v_.unmarshal(_os_);
/* 61 */       this.singleinstanceinfo.add(_v_);
/*    */     }
/* 63 */     this.singlefailtime = _os_.unmarshal_int();
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SSynSingleInstanceInfo)) {
/* 73 */       SSynSingleInstanceInfo _o_ = (SSynSingleInstanceInfo)_o1_;
/* 74 */       if (!this.singleinstanceinfo.equals(_o_.singleinstanceinfo)) return false;
/* 75 */       if (this.singlefailtime != _o_.singlefailtime) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.singleinstanceinfo.hashCode();
/* 84 */     _h_ += this.singlefailtime;
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.singleinstanceinfo).append(",");
/* 92 */     _sb_.append(this.singlefailtime).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\SSynSingleInstanceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */