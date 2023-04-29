/*    */ package mzm.gsp.market;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class MarketLog implements Marshal
/*    */ {
/*    */   public String rolename;
/*    */   public int price;
/*    */   public int itemidorpetcfgid;
/*    */   public int num;
/*    */   public long time;
/*    */   
/*    */   public MarketLog()
/*    */   {
/* 16 */     this.rolename = "";
/*    */   }
/*    */   
/*    */   public MarketLog(String _rolename_, int _price_, int _itemidorpetcfgid_, int _num_, long _time_) {
/* 20 */     this.rolename = _rolename_;
/* 21 */     this.price = _price_;
/* 22 */     this.itemidorpetcfgid = _itemidorpetcfgid_;
/* 23 */     this.num = _num_;
/* 24 */     this.time = _time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 33 */     _os_.marshal(this.price);
/* 34 */     _os_.marshal(this.itemidorpetcfgid);
/* 35 */     _os_.marshal(this.num);
/* 36 */     _os_.marshal(this.time);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 42 */     this.price = _os_.unmarshal_int();
/* 43 */     this.itemidorpetcfgid = _os_.unmarshal_int();
/* 44 */     this.num = _os_.unmarshal_int();
/* 45 */     this.time = _os_.unmarshal_long();
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof MarketLog)) {
/* 52 */       MarketLog _o_ = (MarketLog)_o1_;
/* 53 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 54 */       if (this.price != _o_.price) return false;
/* 55 */       if (this.itemidorpetcfgid != _o_.itemidorpetcfgid) return false;
/* 56 */       if (this.num != _o_.num) return false;
/* 57 */       if (this.time != _o_.time) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.rolename.hashCode();
/* 66 */     _h_ += this.price;
/* 67 */     _h_ += this.itemidorpetcfgid;
/* 68 */     _h_ += this.num;
/* 69 */     _h_ += (int)this.time;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 77 */     _sb_.append(this.price).append(",");
/* 78 */     _sb_.append(this.itemidorpetcfgid).append(",");
/* 79 */     _sb_.append(this.num).append(",");
/* 80 */     _sb_.append(this.time).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\MarketLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */