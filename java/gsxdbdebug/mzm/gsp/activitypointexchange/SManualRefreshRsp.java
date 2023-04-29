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
/*    */ public class SManualRefreshRsp
/*    */   extends __SManualRefreshRsp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12624905;
/*    */   public int activityid;
/*    */   public int activitypointexchangemallcfgid;
/*    */   public MallInfo mallinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12624905;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SManualRefreshRsp()
/*    */   {
/* 33 */     this.mallinfo = new MallInfo();
/*    */   }
/*    */   
/*    */   public SManualRefreshRsp(int _activityid_, int _activitypointexchangemallcfgid_, MallInfo _mallinfo_) {
/* 37 */     this.activityid = _activityid_;
/* 38 */     this.activitypointexchangemallcfgid = _activitypointexchangemallcfgid_;
/* 39 */     this.mallinfo = _mallinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.mallinfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.activityid);
/* 49 */     _os_.marshal(this.activitypointexchangemallcfgid);
/* 50 */     _os_.marshal(this.mallinfo);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.activityid = _os_.unmarshal_int();
/* 56 */     this.activitypointexchangemallcfgid = _os_.unmarshal_int();
/* 57 */     this.mallinfo.unmarshal(_os_);
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SManualRefreshRsp)) {
/* 67 */       SManualRefreshRsp _o_ = (SManualRefreshRsp)_o1_;
/* 68 */       if (this.activityid != _o_.activityid) return false;
/* 69 */       if (this.activitypointexchangemallcfgid != _o_.activitypointexchangemallcfgid) return false;
/* 70 */       if (!this.mallinfo.equals(_o_.mallinfo)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.activityid;
/* 79 */     _h_ += this.activitypointexchangemallcfgid;
/* 80 */     _h_ += this.mallinfo.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.activityid).append(",");
/* 88 */     _sb_.append(this.activitypointexchangemallcfgid).append(",");
/* 89 */     _sb_.append(this.mallinfo).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\SManualRefreshRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */