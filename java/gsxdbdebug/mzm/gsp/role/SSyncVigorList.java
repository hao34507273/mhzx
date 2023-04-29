/*    */ package mzm.gsp.role;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
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
/*    */ public class SSyncVigorList
/*    */   extends __SSyncVigorList__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12586003;
/*    */   public HashMap<Integer, ActivityVigor> vigormap;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12586003;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSyncVigorList()
/*    */   {
/* 33 */     this.vigormap = new HashMap();
/*    */   }
/*    */   
/*    */   public SSyncVigorList(HashMap<Integer, ActivityVigor> _vigormap_) {
/* 37 */     this.vigormap = _vigormap_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (Map.Entry<Integer, ActivityVigor> _e_ : this.vigormap.entrySet()) {
/* 42 */       if (!((ActivityVigor)_e_.getValue())._validator_()) return false;
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.compact_uint32(this.vigormap.size());
/* 49 */     for (Map.Entry<Integer, ActivityVigor> _e_ : this.vigormap.entrySet()) {
/* 50 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 51 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 59 */       int _k_ = _os_.unmarshal_int();
/* 60 */       ActivityVigor _v_ = new ActivityVigor();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.vigormap.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SSyncVigorList)) {
/* 73 */       SSyncVigorList _o_ = (SSyncVigorList)_o1_;
/* 74 */       if (!this.vigormap.equals(_o_.vigormap)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.vigormap.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.vigormap).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\SSyncVigorList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */