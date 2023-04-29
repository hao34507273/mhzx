/*    */ package mzm.gsp.role;
/*    */ 
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
/*    */ public class SAutoAssignPrefRes
/*    */   extends __SAutoAssignPrefRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585988;
/*    */   public static final int PROP_SYS_1 = 0;
/*    */   public static final int PROP_SYS_2 = 1;
/*    */   public static final int PROP_SYS_3 = 2;
/*    */   public int propsys;
/*    */   public HashMap<Integer, Integer> assignpropmap;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12585988;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SAutoAssignPrefRes()
/*    */   {
/* 38 */     this.assignpropmap = new HashMap();
/*    */   }
/*    */   
/*    */   public SAutoAssignPrefRes(int _propsys_, HashMap<Integer, Integer> _assignpropmap_) {
/* 42 */     this.propsys = _propsys_;
/* 43 */     this.assignpropmap = _assignpropmap_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.propsys);
/* 52 */     _os_.compact_uint32(this.assignpropmap.size());
/* 53 */     for (Map.Entry<Integer, Integer> _e_ : this.assignpropmap.entrySet()) {
/* 54 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 55 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     this.propsys = _os_.unmarshal_int();
/* 62 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 64 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 66 */       int _v_ = _os_.unmarshal_int();
/* 67 */       this.assignpropmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 69 */     if (!_validator_()) {
/* 70 */       throw new VerifyError("validator failed");
/*    */     }
/* 72 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 76 */     if (_o1_ == this) return true;
/* 77 */     if ((_o1_ instanceof SAutoAssignPrefRes)) {
/* 78 */       SAutoAssignPrefRes _o_ = (SAutoAssignPrefRes)_o1_;
/* 79 */       if (this.propsys != _o_.propsys) return false;
/* 80 */       if (!this.assignpropmap.equals(_o_.assignpropmap)) return false;
/* 81 */       return true;
/*    */     }
/* 83 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 87 */     int _h_ = 0;
/* 88 */     _h_ += this.propsys;
/* 89 */     _h_ += this.assignpropmap.hashCode();
/* 90 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 94 */     StringBuilder _sb_ = new StringBuilder();
/* 95 */     _sb_.append("(");
/* 96 */     _sb_.append(this.propsys).append(",");
/* 97 */     _sb_.append(this.assignpropmap).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\SAutoAssignPrefRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */