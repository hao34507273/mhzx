/*    */ package mzm.gsp.corps;
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
/*    */ 
/*    */ public class SCreateErrAlreadyHaveCorps
/*    */   extends __SCreateErrAlreadyHaveCorps__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617479;
/*    */   public HashMap<Long, Octets> roleid2name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617479;
/*    */   }
/*    */   
/*    */ 
/*    */   public SCreateErrAlreadyHaveCorps()
/*    */   {
/* 33 */     this.roleid2name = new HashMap();
/*    */   }
/*    */   
/*    */   public SCreateErrAlreadyHaveCorps(HashMap<Long, Octets> _roleid2name_) {
/* 37 */     this.roleid2name = _roleid2name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.roleid2name.size());
/* 46 */     for (Map.Entry<Long, Octets> _e_ : this.roleid2name.entrySet()) {
/* 47 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 48 */       _os_.marshal((Octets)_e_.getValue());
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 56 */       long _k_ = _os_.unmarshal_long();
/*    */       
/* 58 */       Octets _v_ = _os_.unmarshal_Octets();
/* 59 */       this.roleid2name.put(Long.valueOf(_k_), _v_);
/*    */     }
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SCreateErrAlreadyHaveCorps)) {
/* 70 */       SCreateErrAlreadyHaveCorps _o_ = (SCreateErrAlreadyHaveCorps)_o1_;
/* 71 */       if (!this.roleid2name.equals(_o_.roleid2name)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.roleid2name.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.roleid2name).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\SCreateErrAlreadyHaveCorps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */