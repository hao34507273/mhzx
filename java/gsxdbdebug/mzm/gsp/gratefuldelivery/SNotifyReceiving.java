/*    */ package mzm.gsp.gratefuldelivery;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SNotifyReceiving
/*    */   extends __SNotifyReceiving__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615685;
/*    */   public long source_id;
/*    */   public Octets source_name;
/*    */   public int time;
/*    */   public int activity_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12615685;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SNotifyReceiving()
/*    */   {
/* 36 */     this.source_name = new Octets();
/*    */   }
/*    */   
/*    */   public SNotifyReceiving(long _source_id_, Octets _source_name_, int _time_, int _activity_id_) {
/* 40 */     this.source_id = _source_id_;
/* 41 */     this.source_name = _source_name_;
/* 42 */     this.time = _time_;
/* 43 */     this.activity_id = _activity_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.source_id);
/* 52 */     _os_.marshal(this.source_name);
/* 53 */     _os_.marshal(this.time);
/* 54 */     _os_.marshal(this.activity_id);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.source_id = _os_.unmarshal_long();
/* 60 */     this.source_name = _os_.unmarshal_Octets();
/* 61 */     this.time = _os_.unmarshal_int();
/* 62 */     this.activity_id = _os_.unmarshal_int();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SNotifyReceiving)) {
/* 72 */       SNotifyReceiving _o_ = (SNotifyReceiving)_o1_;
/* 73 */       if (this.source_id != _o_.source_id) return false;
/* 74 */       if (!this.source_name.equals(_o_.source_name)) return false;
/* 75 */       if (this.time != _o_.time) return false;
/* 76 */       if (this.activity_id != _o_.activity_id) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += (int)this.source_id;
/* 85 */     _h_ += this.source_name.hashCode();
/* 86 */     _h_ += this.time;
/* 87 */     _h_ += this.activity_id;
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.source_id).append(",");
/* 95 */     _sb_.append("B").append(this.source_name.size()).append(",");
/* 96 */     _sb_.append(this.time).append(",");
/* 97 */     _sb_.append(this.activity_id).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\SNotifyReceiving.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */