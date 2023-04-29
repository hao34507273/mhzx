/*    */ package mzm.gsp.indiana;
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
/*    */ public class SGetIndianaLogsSuccess
/*    */   extends __SGetIndianaLogsSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12629005;
/*    */   public int activity_cfg_id;
/*    */   public ArrayList<IndianaLog> logs;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12629005;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetIndianaLogsSuccess()
/*    */   {
/* 34 */     this.logs = new ArrayList();
/*    */   }
/*    */   
/*    */   public SGetIndianaLogsSuccess(int _activity_cfg_id_, ArrayList<IndianaLog> _logs_) {
/* 38 */     this.activity_cfg_id = _activity_cfg_id_;
/* 39 */     this.logs = _logs_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (IndianaLog _v_ : this.logs)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.activity_cfg_id);
/* 50 */     _os_.compact_uint32(this.logs.size());
/* 51 */     for (IndianaLog _v_ : this.logs) {
/* 52 */       _os_.marshal(_v_);
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 60 */       IndianaLog _v_ = new IndianaLog();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.logs.add(_v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SGetIndianaLogsSuccess)) {
/* 73 */       SGetIndianaLogsSuccess _o_ = (SGetIndianaLogsSuccess)_o1_;
/* 74 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 75 */       if (!this.logs.equals(_o_.logs)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.activity_cfg_id;
/* 84 */     _h_ += this.logs.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.activity_cfg_id).append(",");
/* 92 */     _sb_.append(this.logs).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\SGetIndianaLogsSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */