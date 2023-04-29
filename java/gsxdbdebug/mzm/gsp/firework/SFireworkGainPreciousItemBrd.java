/*    */ package mzm.gsp.firework;
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
/*    */ public class SFireworkGainPreciousItemBrd
/*    */   extends __SFireworkGainPreciousItemBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12625159;
/*    */   public Octets name;
/*    */   public HashMap<Integer, Integer> items;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12625159;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SFireworkGainPreciousItemBrd()
/*    */   {
/* 34 */     this.name = new Octets();
/* 35 */     this.items = new HashMap();
/*    */   }
/*    */   
/*    */   public SFireworkGainPreciousItemBrd(Octets _name_, HashMap<Integer, Integer> _items_) {
/* 39 */     this.name = _name_;
/* 40 */     this.items = _items_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.name);
/* 49 */     _os_.compact_uint32(this.items.size());
/* 50 */     for (Map.Entry<Integer, Integer> _e_ : this.items.entrySet()) {
/* 51 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 52 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.name = _os_.unmarshal_Octets();
/* 59 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 61 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 63 */       int _v_ = _os_.unmarshal_int();
/* 64 */       this.items.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SFireworkGainPreciousItemBrd)) {
/* 75 */       SFireworkGainPreciousItemBrd _o_ = (SFireworkGainPreciousItemBrd)_o1_;
/* 76 */       if (!this.name.equals(_o_.name)) return false;
/* 77 */       if (!this.items.equals(_o_.items)) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.name.hashCode();
/* 86 */     _h_ += this.items.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append("B").append(this.name.size()).append(",");
/* 94 */     _sb_.append(this.items).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\SFireworkGainPreciousItemBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */