/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import xbean.BuffInfo;
/*     */ import xbean.ZoneInfo;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class SingleBattleBuff extends XBean implements xbean.SingleBattleBuff
/*     */ {
/*     */   private Session session;
/*     */   private HashMap<Integer, BuffInfo> buff_infos;
/*     */   private HashMap<Integer, ZoneInfo> zone_infos;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.session = null;
/*  23 */     this.buff_infos.clear();
/*  24 */     this.zone_infos.clear();
/*     */   }
/*     */   
/*     */   SingleBattleBuff(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.session = null;
/*  31 */     this.buff_infos = new HashMap();
/*  32 */     this.zone_infos = new HashMap();
/*     */   }
/*     */   
/*     */   public SingleBattleBuff()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public SingleBattleBuff(SingleBattleBuff _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   SingleBattleBuff(xbean.SingleBattleBuff _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  54 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  60 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  66 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws ppbio.InvalidProtocolBufferException
/*     */   {
/*  72 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws ppbio.InvalidProtocolBufferException
/*     */   {
/*  78 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SingleBattleBuff copy()
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     return new SingleBattleBuff(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SingleBattleBuff toData()
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SingleBattleBuff toBean()
/*     */   {
/*  97 */     _xdb_verify_unsafe_();
/*  98 */     return new SingleBattleBuff(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SingleBattleBuff toDataIf()
/*     */   {
/* 104 */     _xdb_verify_unsafe_();
/* 105 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SingleBattleBuff toBeanIf()
/*     */   {
/* 110 */     _xdb_verify_unsafe_();
/* 111 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/* 118 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Session getSession()
/*     */   {
/* 125 */     _xdb_verify_unsafe_();
/* 126 */     return this.session;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, BuffInfo> getBuff_infos()
/*     */   {
/* 133 */     _xdb_verify_unsafe_();
/* 134 */     return xdb.Logs.logMap(new xdb.LogKey(this, "buff_infos"), this.buff_infos);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, BuffInfo> getBuff_infosAsData()
/*     */   {
/* 141 */     _xdb_verify_unsafe_();
/*     */     
/* 143 */     SingleBattleBuff _o_ = this;
/* 144 */     Map<Integer, BuffInfo> buff_infos = new HashMap();
/* 145 */     for (Map.Entry<Integer, BuffInfo> _e_ : _o_.buff_infos.entrySet())
/* 146 */       buff_infos.put(_e_.getKey(), new BuffInfo.Data((BuffInfo)_e_.getValue()));
/* 147 */     return buff_infos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, ZoneInfo> getZone_infos()
/*     */   {
/* 154 */     _xdb_verify_unsafe_();
/* 155 */     return xdb.Logs.logMap(new xdb.LogKey(this, "zone_infos"), this.zone_infos);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, ZoneInfo> getZone_infosAsData()
/*     */   {
/* 162 */     _xdb_verify_unsafe_();
/*     */     
/* 164 */     SingleBattleBuff _o_ = this;
/* 165 */     Map<Integer, ZoneInfo> zone_infos = new HashMap();
/* 166 */     for (Map.Entry<Integer, ZoneInfo> _e_ : _o_.zone_infos.entrySet())
/* 167 */       zone_infos.put(_e_.getKey(), new ZoneInfo.Data((ZoneInfo)_e_.getValue()));
/* 168 */     return zone_infos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSession(Session _v_)
/*     */   {
/* 175 */     _xdb_verify_unsafe_();
/* 176 */     xdb.Logs.logIf(new xdb.LogKey(this, "session")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 180 */         new xdb.logs.LogObject(this, SingleBattleBuff.this.session)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 184 */             SingleBattleBuff.this.session = ((Session)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 188 */     });
/* 189 */     this.session = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 195 */     _xdb_verify_unsafe_();
/* 196 */     SingleBattleBuff _o_ = null;
/* 197 */     if ((_o1_ instanceof SingleBattleBuff)) { _o_ = (SingleBattleBuff)_o1_;
/* 198 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 199 */       return false;
/* 200 */     if (((null == this.session) && (null != _o_.session)) || ((null != this.session) && (null == _o_.session)) || ((null != this.session) && (null != _o_.session) && (!this.session.equals(_o_.session)))) return false;
/* 201 */     if (!this.buff_infos.equals(_o_.buff_infos)) return false;
/* 202 */     if (!this.zone_infos.equals(_o_.zone_infos)) return false;
/* 203 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 209 */     _xdb_verify_unsafe_();
/* 210 */     int _h_ = 0;
/* 211 */     _h_ += (this.session == null ? 0 : this.session.hashCode());
/* 212 */     _h_ += this.buff_infos.hashCode();
/* 213 */     _h_ += this.zone_infos.hashCode();
/* 214 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     StringBuilder _sb_ = new StringBuilder();
/* 222 */     _sb_.append("(");
/* 223 */     _sb_.append(this.session);
/* 224 */     _sb_.append(",");
/* 225 */     _sb_.append(this.buff_infos);
/* 226 */     _sb_.append(",");
/* 227 */     _sb_.append(this.zone_infos);
/* 228 */     _sb_.append(")");
/* 229 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 235 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 236 */     lb.add(new xdb.logs.ListenableChanged().setVarName("session"));
/* 237 */     lb.add(new xdb.logs.ListenableMap().setVarName("buff_infos"));
/* 238 */     lb.add(new xdb.logs.ListenableMap().setVarName("zone_infos"));
/* 239 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.SingleBattleBuff {
/*     */     private Const() {}
/*     */     
/*     */     SingleBattleBuff nThis() {
/* 246 */       return SingleBattleBuff.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 252 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleBattleBuff copy()
/*     */     {
/* 258 */       return SingleBattleBuff.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleBattleBuff toData()
/*     */     {
/* 264 */       return SingleBattleBuff.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.SingleBattleBuff toBean()
/*     */     {
/* 269 */       return SingleBattleBuff.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleBattleBuff toDataIf()
/*     */     {
/* 275 */       return SingleBattleBuff.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.SingleBattleBuff toBeanIf()
/*     */     {
/* 280 */       return SingleBattleBuff.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Session getSession()
/*     */     {
/* 287 */       SingleBattleBuff.this._xdb_verify_unsafe_();
/* 288 */       return SingleBattleBuff.this.session;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, BuffInfo> getBuff_infos()
/*     */     {
/* 295 */       SingleBattleBuff.this._xdb_verify_unsafe_();
/* 296 */       return xdb.Consts.constMap(SingleBattleBuff.this.buff_infos);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, BuffInfo> getBuff_infosAsData()
/*     */     {
/* 303 */       SingleBattleBuff.this._xdb_verify_unsafe_();
/*     */       
/* 305 */       SingleBattleBuff _o_ = SingleBattleBuff.this;
/* 306 */       Map<Integer, BuffInfo> buff_infos = new HashMap();
/* 307 */       for (Map.Entry<Integer, BuffInfo> _e_ : _o_.buff_infos.entrySet())
/* 308 */         buff_infos.put(_e_.getKey(), new BuffInfo.Data((BuffInfo)_e_.getValue()));
/* 309 */       return buff_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, ZoneInfo> getZone_infos()
/*     */     {
/* 316 */       SingleBattleBuff.this._xdb_verify_unsafe_();
/* 317 */       return xdb.Consts.constMap(SingleBattleBuff.this.zone_infos);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, ZoneInfo> getZone_infosAsData()
/*     */     {
/* 324 */       SingleBattleBuff.this._xdb_verify_unsafe_();
/*     */       
/* 326 */       SingleBattleBuff _o_ = SingleBattleBuff.this;
/* 327 */       Map<Integer, ZoneInfo> zone_infos = new HashMap();
/* 328 */       for (Map.Entry<Integer, ZoneInfo> _e_ : _o_.zone_infos.entrySet())
/* 329 */         zone_infos.put(_e_.getKey(), new ZoneInfo.Data((ZoneInfo)_e_.getValue()));
/* 330 */       return zone_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSession(Session _v_)
/*     */     {
/* 337 */       SingleBattleBuff.this._xdb_verify_unsafe_();
/* 338 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 344 */       SingleBattleBuff.this._xdb_verify_unsafe_();
/* 345 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 351 */       SingleBattleBuff.this._xdb_verify_unsafe_();
/* 352 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 358 */       return SingleBattleBuff.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 364 */       return SingleBattleBuff.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 370 */       SingleBattleBuff.this._xdb_verify_unsafe_();
/* 371 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 377 */       return SingleBattleBuff.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws ppbio.InvalidProtocolBufferException
/*     */     {
/* 383 */       return SingleBattleBuff.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws ppbio.InvalidProtocolBufferException
/*     */     {
/* 389 */       SingleBattleBuff.this._xdb_verify_unsafe_();
/* 390 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 396 */       return SingleBattleBuff.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 402 */       return SingleBattleBuff.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 408 */       return SingleBattleBuff.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 414 */       return SingleBattleBuff.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 420 */       return SingleBattleBuff.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 426 */       return SingleBattleBuff.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 432 */       return SingleBattleBuff.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.SingleBattleBuff
/*     */   {
/*     */     private Session session;
/*     */     
/*     */     private HashMap<Integer, BuffInfo> buff_infos;
/*     */     
/*     */     private HashMap<Integer, ZoneInfo> zone_infos;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 448 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 453 */       this.session = null;
/* 454 */       this.buff_infos = new HashMap();
/* 455 */       this.zone_infos = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.SingleBattleBuff _o1_)
/*     */     {
/* 460 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 466 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 472 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 478 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws ppbio.InvalidProtocolBufferException
/*     */     {
/* 484 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws ppbio.InvalidProtocolBufferException
/*     */     {
/* 490 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleBattleBuff copy()
/*     */     {
/* 496 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleBattleBuff toData()
/*     */     {
/* 502 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.SingleBattleBuff toBean()
/*     */     {
/* 507 */       return new SingleBattleBuff(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleBattleBuff toDataIf()
/*     */     {
/* 513 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.SingleBattleBuff toBeanIf()
/*     */     {
/* 518 */       return new SingleBattleBuff(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 524 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 532 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 536 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 540 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 544 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 548 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Session getSession()
/*     */     {
/* 555 */       return this.session;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, BuffInfo> getBuff_infos()
/*     */     {
/* 562 */       return this.buff_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, BuffInfo> getBuff_infosAsData()
/*     */     {
/* 569 */       return this.buff_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, ZoneInfo> getZone_infos()
/*     */     {
/* 576 */       return this.zone_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, ZoneInfo> getZone_infosAsData()
/*     */     {
/* 583 */       return this.zone_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSession(Session _v_)
/*     */     {
/* 590 */       this.session = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 596 */       if (!(_o1_ instanceof Data)) return false;
/* 597 */       Data _o_ = (Data)_o1_;
/* 598 */       if (((null == this.session) && (null != _o_.session)) || ((null != this.session) && (null == _o_.session)) || ((null != this.session) && (null != _o_.session) && (!this.session.equals(_o_.session)))) return false;
/* 599 */       if (!this.buff_infos.equals(_o_.buff_infos)) return false;
/* 600 */       if (!this.zone_infos.equals(_o_.zone_infos)) return false;
/* 601 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 607 */       int _h_ = 0;
/* 608 */       _h_ += (this.session == null ? 0 : this.session.hashCode());
/* 609 */       _h_ += this.buff_infos.hashCode();
/* 610 */       _h_ += this.zone_infos.hashCode();
/* 611 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 617 */       StringBuilder _sb_ = new StringBuilder();
/* 618 */       _sb_.append("(");
/* 619 */       _sb_.append(this.session);
/* 620 */       _sb_.append(",");
/* 621 */       _sb_.append(this.buff_infos);
/* 622 */       _sb_.append(",");
/* 623 */       _sb_.append(this.zone_infos);
/* 624 */       _sb_.append(")");
/* 625 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SingleBattleBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */