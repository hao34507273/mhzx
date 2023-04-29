/*    */ package mzm.gsp.activity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class RoleAwardData implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public String rolename;
/*    */   public HashMap<Integer, Integer> items;
/*    */   
/*    */   public RoleAwardData()
/*    */   {
/* 14 */     this.rolename = "";
/* 15 */     this.items = new HashMap();
/*    */   }
/*    */   
/*    */   public RoleAwardData(long _roleid_, String _rolename_, HashMap<Integer, Integer> _items_) {
/* 19 */     this.roleid = _roleid_;
/* 20 */     this.rolename = _rolename_;
/* 21 */     this.items = _items_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.roleid);
/* 30 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 31 */     _os_.compact_uint32(this.items.size());
/* 32 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.items.entrySet()) {
/* 33 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 34 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 40 */     this.roleid = _os_.unmarshal_long();
/* 41 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 42 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 44 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 46 */       int _v_ = _os_.unmarshal_int();
/* 47 */       this.items.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof RoleAwardData)) {
/* 55 */       RoleAwardData _o_ = (RoleAwardData)_o1_;
/* 56 */       if (this.roleid != _o_.roleid) return false;
/* 57 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 58 */       if (!this.items.equals(_o_.items)) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += (int)this.roleid;
/* 67 */     _h_ += this.rolename.hashCode();
/* 68 */     _h_ += this.items.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.roleid).append(",");
/* 76 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 77 */     _sb_.append(this.items).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\RoleAwardData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */