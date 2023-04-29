/*    */ package mzm.gsp.apollo;
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
/*    */ 
/*    */ public class SApolloEnterLargeRoomRsp
/*    */   extends __SApolloEnterLargeRoomRsp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12602626;
/*    */   public int retcode;
/*    */   public LinkedList<LargeRoomEnterRspInfo> rsp_infos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12602626;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SApolloEnterLargeRoomRsp()
/*    */   {
/* 34 */     this.retcode = 9;
/* 35 */     this.rsp_infos = new LinkedList();
/*    */   }
/*    */   
/*    */   public SApolloEnterLargeRoomRsp(int _retcode_, LinkedList<LargeRoomEnterRspInfo> _rsp_infos_) {
/* 39 */     this.retcode = _retcode_;
/* 40 */     this.rsp_infos = _rsp_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     for (LargeRoomEnterRspInfo _v_ : this.rsp_infos)
/* 45 */       if (!_v_._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.retcode);
/* 51 */     _os_.compact_uint32(this.rsp_infos.size());
/* 52 */     for (LargeRoomEnterRspInfo _v_ : this.rsp_infos) {
/* 53 */       _os_.marshal(_v_);
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.retcode = _os_.unmarshal_int();
/* 60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 61 */       LargeRoomEnterRspInfo _v_ = new LargeRoomEnterRspInfo();
/* 62 */       _v_.unmarshal(_os_);
/* 63 */       this.rsp_infos.add(_v_);
/*    */     }
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof SApolloEnterLargeRoomRsp)) {
/* 74 */       SApolloEnterLargeRoomRsp _o_ = (SApolloEnterLargeRoomRsp)_o1_;
/* 75 */       if (this.retcode != _o_.retcode) return false;
/* 76 */       if (!this.rsp_infos.equals(_o_.rsp_infos)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.retcode;
/* 85 */     _h_ += this.rsp_infos.hashCode();
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.retcode).append(",");
/* 93 */     _sb_.append(this.rsp_infos).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\SApolloEnterLargeRoomRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */