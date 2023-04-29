/*    */ package mzm.gsp.fabaolingqi;
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
/*    */ public class SSyncArtifactInformation
/*    */   extends __SSyncArtifactInformation__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618248;
/*    */   public HashMap<Integer, FabaoArtifactInfo> artifact_map;
/*    */   public int equipped_artifact_class;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12618248;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncArtifactInformation()
/*    */   {
/* 34 */     this.artifact_map = new HashMap();
/*    */   }
/*    */   
/*    */   public SSyncArtifactInformation(HashMap<Integer, FabaoArtifactInfo> _artifact_map_, int _equipped_artifact_class_) {
/* 38 */     this.artifact_map = _artifact_map_;
/* 39 */     this.equipped_artifact_class = _equipped_artifact_class_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (Map.Entry<Integer, FabaoArtifactInfo> _e_ : this.artifact_map.entrySet()) {
/* 44 */       if (!((FabaoArtifactInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.compact_uint32(this.artifact_map.size());
/* 51 */     for (Map.Entry<Integer, FabaoArtifactInfo> _e_ : this.artifact_map.entrySet()) {
/* 52 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 53 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 55 */     _os_.marshal(this.equipped_artifact_class);
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 62 */       int _k_ = _os_.unmarshal_int();
/* 63 */       FabaoArtifactInfo _v_ = new FabaoArtifactInfo();
/* 64 */       _v_.unmarshal(_os_);
/* 65 */       this.artifact_map.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 67 */     this.equipped_artifact_class = _os_.unmarshal_int();
/* 68 */     if (!_validator_()) {
/* 69 */       throw new VerifyError("validator failed");
/*    */     }
/* 71 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 75 */     if (_o1_ == this) return true;
/* 76 */     if ((_o1_ instanceof SSyncArtifactInformation)) {
/* 77 */       SSyncArtifactInformation _o_ = (SSyncArtifactInformation)_o1_;
/* 78 */       if (!this.artifact_map.equals(_o_.artifact_map)) return false;
/* 79 */       if (this.equipped_artifact_class != _o_.equipped_artifact_class) return false;
/* 80 */       return true;
/*    */     }
/* 82 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 86 */     int _h_ = 0;
/* 87 */     _h_ += this.artifact_map.hashCode();
/* 88 */     _h_ += this.equipped_artifact_class;
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.artifact_map).append(",");
/* 96 */     _sb_.append(this.equipped_artifact_class).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\SSyncArtifactInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */