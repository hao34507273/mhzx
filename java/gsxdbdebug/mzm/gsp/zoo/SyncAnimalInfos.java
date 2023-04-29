/*    */ package mzm.gsp.zoo;
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
/*    */ public class SyncAnimalInfos
/*    */   extends __SyncAnimalInfos__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615428;
/*    */   public HashMap<Long, AnimalInfo> animals;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12615428;
/*    */   }
/*    */   
/*    */ 
/*    */   public SyncAnimalInfos()
/*    */   {
/* 33 */     this.animals = new HashMap();
/*    */   }
/*    */   
/*    */   public SyncAnimalInfos(HashMap<Long, AnimalInfo> _animals_) {
/* 37 */     this.animals = _animals_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (Map.Entry<Long, AnimalInfo> _e_ : this.animals.entrySet()) {
/* 42 */       if (!((AnimalInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.compact_uint32(this.animals.size());
/* 49 */     for (Map.Entry<Long, AnimalInfo> _e_ : this.animals.entrySet()) {
/* 50 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 51 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 59 */       long _k_ = _os_.unmarshal_long();
/* 60 */       AnimalInfo _v_ = new AnimalInfo();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.animals.put(Long.valueOf(_k_), _v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SyncAnimalInfos)) {
/* 73 */       SyncAnimalInfos _o_ = (SyncAnimalInfos)_o1_;
/* 74 */       if (!this.animals.equals(_o_.animals)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.animals.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.animals).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\SyncAnimalInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */