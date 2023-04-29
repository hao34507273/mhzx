/*    */ package mzm.gsp.gratefuldelivery;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SNotifyDistribution
/*    */   extends __SNotifyDistribution__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615682;
/*    */   public HashMap<Long, Octets> roles;
/*    */   public int activity_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12615682;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SNotifyDistribution()
/*    */   {
/* 34 */     this.roles = new HashMap();
/*    */   }
/*    */   
/*    */   public SNotifyDistribution(HashMap<Long, Octets> _roles_, int _activity_id_) {
/* 38 */     this.roles = _roles_;
/* 39 */     this.activity_id = _activity_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.roles.size());
/* 48 */     for (Map.Entry<Long, Octets> _e_ : this.roles.entrySet()) {
/* 49 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 50 */       _os_.marshal((Octets)_e_.getValue());
/*    */     }
/* 52 */     _os_.marshal(this.activity_id);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 59 */       long _k_ = _os_.unmarshal_long();
/*    */       
/* 61 */       Octets _v_ = _os_.unmarshal_Octets();
/* 62 */       this.roles.put(Long.valueOf(_k_), _v_);
/*    */     }
/* 64 */     this.activity_id = _os_.unmarshal_int();
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof SNotifyDistribution)) {
/* 74 */       SNotifyDistribution _o_ = (SNotifyDistribution)_o1_;
/* 75 */       if (!this.roles.equals(_o_.roles)) return false;
/* 76 */       if (this.activity_id != _o_.activity_id) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.roles.hashCode();
/* 85 */     _h_ += this.activity_id;
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.roles).append(",");
/* 93 */     _sb_.append(this.activity_id).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\SNotifyDistribution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */