/*    */ package mzm.gsp.activitypointexchange;
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
/*    */ public class SSoldOutInfoRsp
/*    */   extends __SSoldOutInfoRsp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12624906;
/*    */   public int activityid;
/*    */   public int activitypointexchangemallcfgid;
/*    */   public SoldOutInfo soldoutinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12624906;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSoldOutInfoRsp()
/*    */   {
/* 33 */     this.soldoutinfo = new SoldOutInfo();
/*    */   }
/*    */   
/*    */   public SSoldOutInfoRsp(int _activityid_, int _activitypointexchangemallcfgid_, SoldOutInfo _soldoutinfo_) {
/* 37 */     this.activityid = _activityid_;
/* 38 */     this.activitypointexchangemallcfgid = _activitypointexchangemallcfgid_;
/* 39 */     this.soldoutinfo = _soldoutinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.soldoutinfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.activityid);
/* 49 */     _os_.marshal(this.activitypointexchangemallcfgid);
/* 50 */     _os_.marshal(this.soldoutinfo);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.activityid = _os_.unmarshal_int();
/* 56 */     this.activitypointexchangemallcfgid = _os_.unmarshal_int();
/* 57 */     this.soldoutinfo.unmarshal(_os_);
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SSoldOutInfoRsp)) {
/* 67 */       SSoldOutInfoRsp _o_ = (SSoldOutInfoRsp)_o1_;
/* 68 */       if (this.activityid != _o_.activityid) return false;
/* 69 */       if (this.activitypointexchangemallcfgid != _o_.activitypointexchangemallcfgid) return false;
/* 70 */       if (!this.soldoutinfo.equals(_o_.soldoutinfo)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.activityid;
/* 79 */     _h_ += this.activitypointexchangemallcfgid;
/* 80 */     _h_ += this.soldoutinfo.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.activityid).append(",");
/* 88 */     _sb_.append(this.activitypointexchangemallcfgid).append(",");
/* 89 */     _sb_.append(this.soldoutinfo).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\SSoldOutInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */