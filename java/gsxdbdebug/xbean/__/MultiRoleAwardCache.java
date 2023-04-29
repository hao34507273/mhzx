/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import xbean.Item2CountBean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class MultiRoleAwardCache extends XBean implements xbean.MultiRoleAwardCache
/*     */ {
/*     */   private ArrayList<Long> roles;
/*     */   private ArrayList<Item2CountBean> awarditemids;
/*     */   private HashMap<Integer, Long> indexmap;
/*     */   private xdb.util.SetX<Long> operroleids;
/*     */   private TLogArg tlogarg;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.roles.clear();
/*  27 */     this.awarditemids.clear();
/*  28 */     this.indexmap.clear();
/*  29 */     this.operroleids.clear();
/*  30 */     this.tlogarg = null;
/*     */   }
/*     */   
/*     */   MultiRoleAwardCache(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*  36 */     this.roles = new ArrayList();
/*  37 */     this.awarditemids = new ArrayList();
/*  38 */     this.indexmap = new HashMap();
/*  39 */     this.operroleids = new xdb.util.SetX();
/*  40 */     this.tlogarg = null;
/*     */   }
/*     */   
/*     */   public MultiRoleAwardCache()
/*     */   {
/*  45 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MultiRoleAwardCache(MultiRoleAwardCache _o_)
/*     */   {
/*  50 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MultiRoleAwardCache(xbean.MultiRoleAwardCache _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  55 */     super(_xp_, _vn_);
/*  56 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  62 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  68 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  74 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws ppbio.InvalidProtocolBufferException
/*     */   {
/*  80 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws ppbio.InvalidProtocolBufferException
/*     */   {
/*  86 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MultiRoleAwardCache copy()
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     return new MultiRoleAwardCache(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MultiRoleAwardCache toData()
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/* 100 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MultiRoleAwardCache toBean()
/*     */   {
/* 105 */     _xdb_verify_unsafe_();
/* 106 */     return new MultiRoleAwardCache(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MultiRoleAwardCache toDataIf()
/*     */   {
/* 112 */     _xdb_verify_unsafe_();
/* 113 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MultiRoleAwardCache toBeanIf()
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/* 119 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 125 */     _xdb_verify_unsafe_();
/* 126 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getRoles()
/*     */   {
/* 133 */     _xdb_verify_unsafe_();
/* 134 */     return xdb.Logs.logList(new LogKey(this, "roles"), this.roles);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getRolesAsData()
/*     */   {
/* 140 */     _xdb_verify_unsafe_();
/*     */     
/* 142 */     MultiRoleAwardCache _o_ = this;
/* 143 */     List<Long> roles = new ArrayList();
/* 144 */     roles.addAll(_o_.roles);
/* 145 */     return roles;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Item2CountBean> getAwarditemids()
/*     */   {
/* 152 */     _xdb_verify_unsafe_();
/* 153 */     return xdb.Logs.logList(new LogKey(this, "awarditemids"), this.awarditemids);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Item2CountBean> getAwarditemidsAsData()
/*     */   {
/* 159 */     _xdb_verify_unsafe_();
/*     */     
/* 161 */     MultiRoleAwardCache _o_ = this;
/* 162 */     List<Item2CountBean> awarditemids = new ArrayList();
/* 163 */     for (Item2CountBean _v_ : _o_.awarditemids)
/* 164 */       awarditemids.add(new Item2CountBean.Data(_v_));
/* 165 */     return awarditemids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Long> getIndexmap()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return xdb.Logs.logMap(new LogKey(this, "indexmap"), this.indexmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Long> getIndexmapAsData()
/*     */   {
/* 180 */     _xdb_verify_unsafe_();
/*     */     
/* 182 */     MultiRoleAwardCache _o_ = this;
/* 183 */     Map<Integer, Long> indexmap = new HashMap();
/* 184 */     for (java.util.Map.Entry<Integer, Long> _e_ : _o_.indexmap.entrySet())
/* 185 */       indexmap.put(_e_.getKey(), _e_.getValue());
/* 186 */     return indexmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getOperroleids()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return xdb.Logs.logSet(new LogKey(this, "operroleids"), this.operroleids);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getOperroleidsAsData()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/*     */     
/* 202 */     MultiRoleAwardCache _o_ = this;
/* 203 */     Set<Long> operroleids = new xdb.util.SetX();
/* 204 */     operroleids.addAll(_o_.operroleids);
/* 205 */     return operroleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public TLogArg getTlogarg()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.tlogarg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTlogarg(TLogArg _v_)
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     xdb.Logs.logIf(new LogKey(this, "tlogarg")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 225 */         new xdb.logs.LogObject(this, MultiRoleAwardCache.this.tlogarg)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 229 */             MultiRoleAwardCache.this.tlogarg = ((TLogArg)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 233 */     });
/* 234 */     this.tlogarg = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     MultiRoleAwardCache _o_ = null;
/* 242 */     if ((_o1_ instanceof MultiRoleAwardCache)) { _o_ = (MultiRoleAwardCache)_o1_;
/* 243 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 244 */       return false;
/* 245 */     if (!this.roles.equals(_o_.roles)) return false;
/* 246 */     if (!this.awarditemids.equals(_o_.awarditemids)) return false;
/* 247 */     if (!this.indexmap.equals(_o_.indexmap)) return false;
/* 248 */     if (!this.operroleids.equals(_o_.operroleids)) return false;
/* 249 */     if (((null == this.tlogarg) && (null != _o_.tlogarg)) || ((null != this.tlogarg) && (null == _o_.tlogarg)) || ((null != this.tlogarg) && (null != _o_.tlogarg) && (!this.tlogarg.equals(_o_.tlogarg)))) return false;
/* 250 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/* 257 */     int _h_ = 0;
/* 258 */     _h_ += this.roles.hashCode();
/* 259 */     _h_ += this.awarditemids.hashCode();
/* 260 */     _h_ += this.indexmap.hashCode();
/* 261 */     _h_ += this.operroleids.hashCode();
/* 262 */     _h_ += (this.tlogarg == null ? 0 : this.tlogarg.hashCode());
/* 263 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     StringBuilder _sb_ = new StringBuilder();
/* 271 */     _sb_.append("(");
/* 272 */     _sb_.append(this.roles);
/* 273 */     _sb_.append(",");
/* 274 */     _sb_.append(this.awarditemids);
/* 275 */     _sb_.append(",");
/* 276 */     _sb_.append(this.indexmap);
/* 277 */     _sb_.append(",");
/* 278 */     _sb_.append(this.operroleids);
/* 279 */     _sb_.append(",");
/* 280 */     _sb_.append(this.tlogarg);
/* 281 */     _sb_.append(")");
/* 282 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 288 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 289 */     lb.add(new xdb.logs.ListenableChanged().setVarName("roles"));
/* 290 */     lb.add(new xdb.logs.ListenableChanged().setVarName("awarditemids"));
/* 291 */     lb.add(new xdb.logs.ListenableMap().setVarName("indexmap"));
/* 292 */     lb.add(new xdb.logs.ListenableSet().setVarName("operroleids"));
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("tlogarg"));
/* 294 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MultiRoleAwardCache {
/*     */     private Const() {}
/*     */     
/*     */     MultiRoleAwardCache nThis() {
/* 301 */       return MultiRoleAwardCache.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 307 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiRoleAwardCache copy()
/*     */     {
/* 313 */       return MultiRoleAwardCache.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiRoleAwardCache toData()
/*     */     {
/* 319 */       return MultiRoleAwardCache.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MultiRoleAwardCache toBean()
/*     */     {
/* 324 */       return MultiRoleAwardCache.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiRoleAwardCache toDataIf()
/*     */     {
/* 330 */       return MultiRoleAwardCache.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MultiRoleAwardCache toBeanIf()
/*     */     {
/* 335 */       return MultiRoleAwardCache.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRoles()
/*     */     {
/* 342 */       MultiRoleAwardCache.this._xdb_verify_unsafe_();
/* 343 */       return xdb.Consts.constList(MultiRoleAwardCache.this.roles);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getRolesAsData()
/*     */     {
/* 349 */       MultiRoleAwardCache.this._xdb_verify_unsafe_();
/*     */       
/* 351 */       MultiRoleAwardCache _o_ = MultiRoleAwardCache.this;
/* 352 */       List<Long> roles = new ArrayList();
/* 353 */       roles.addAll(_o_.roles);
/* 354 */       return roles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Item2CountBean> getAwarditemids()
/*     */     {
/* 361 */       MultiRoleAwardCache.this._xdb_verify_unsafe_();
/* 362 */       return xdb.Consts.constList(MultiRoleAwardCache.this.awarditemids);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Item2CountBean> getAwarditemidsAsData()
/*     */     {
/* 368 */       MultiRoleAwardCache.this._xdb_verify_unsafe_();
/*     */       
/* 370 */       MultiRoleAwardCache _o_ = MultiRoleAwardCache.this;
/* 371 */       List<Item2CountBean> awarditemids = new ArrayList();
/* 372 */       for (Item2CountBean _v_ : _o_.awarditemids)
/* 373 */         awarditemids.add(new Item2CountBean.Data(_v_));
/* 374 */       return awarditemids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getIndexmap()
/*     */     {
/* 381 */       MultiRoleAwardCache.this._xdb_verify_unsafe_();
/* 382 */       return xdb.Consts.constMap(MultiRoleAwardCache.this.indexmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getIndexmapAsData()
/*     */     {
/* 389 */       MultiRoleAwardCache.this._xdb_verify_unsafe_();
/*     */       
/* 391 */       MultiRoleAwardCache _o_ = MultiRoleAwardCache.this;
/* 392 */       Map<Integer, Long> indexmap = new HashMap();
/* 393 */       for (java.util.Map.Entry<Integer, Long> _e_ : _o_.indexmap.entrySet())
/* 394 */         indexmap.put(_e_.getKey(), _e_.getValue());
/* 395 */       return indexmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getOperroleids()
/*     */     {
/* 402 */       MultiRoleAwardCache.this._xdb_verify_unsafe_();
/* 403 */       return xdb.Consts.constSet(MultiRoleAwardCache.this.operroleids);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getOperroleidsAsData()
/*     */     {
/* 409 */       MultiRoleAwardCache.this._xdb_verify_unsafe_();
/*     */       
/* 411 */       MultiRoleAwardCache _o_ = MultiRoleAwardCache.this;
/* 412 */       Set<Long> operroleids = new xdb.util.SetX();
/* 413 */       operroleids.addAll(_o_.operroleids);
/* 414 */       return operroleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public TLogArg getTlogarg()
/*     */     {
/* 421 */       MultiRoleAwardCache.this._xdb_verify_unsafe_();
/* 422 */       return MultiRoleAwardCache.this.tlogarg;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTlogarg(TLogArg _v_)
/*     */     {
/* 429 */       MultiRoleAwardCache.this._xdb_verify_unsafe_();
/* 430 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 436 */       MultiRoleAwardCache.this._xdb_verify_unsafe_();
/* 437 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 443 */       MultiRoleAwardCache.this._xdb_verify_unsafe_();
/* 444 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 450 */       return MultiRoleAwardCache.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 456 */       return MultiRoleAwardCache.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 462 */       MultiRoleAwardCache.this._xdb_verify_unsafe_();
/* 463 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 469 */       return MultiRoleAwardCache.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws ppbio.InvalidProtocolBufferException
/*     */     {
/* 475 */       return MultiRoleAwardCache.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws ppbio.InvalidProtocolBufferException
/*     */     {
/* 481 */       MultiRoleAwardCache.this._xdb_verify_unsafe_();
/* 482 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 488 */       return MultiRoleAwardCache.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 494 */       return MultiRoleAwardCache.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 500 */       return MultiRoleAwardCache.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 506 */       return MultiRoleAwardCache.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 512 */       return MultiRoleAwardCache.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 518 */       return MultiRoleAwardCache.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 524 */       return MultiRoleAwardCache.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MultiRoleAwardCache
/*     */   {
/*     */     private ArrayList<Long> roles;
/*     */     
/*     */     private ArrayList<Item2CountBean> awarditemids;
/*     */     
/*     */     private HashMap<Integer, Long> indexmap;
/*     */     
/*     */     private java.util.HashSet<Long> operroleids;
/*     */     
/*     */     private TLogArg tlogarg;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 549 */       this.roles = new ArrayList();
/* 550 */       this.awarditemids = new ArrayList();
/* 551 */       this.indexmap = new HashMap();
/* 552 */       this.operroleids = new java.util.HashSet();
/* 553 */       this.tlogarg = null;
/*     */     }
/*     */     
/*     */     Data(xbean.MultiRoleAwardCache _o1_)
/*     */     {
/* 558 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 564 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 570 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 576 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws ppbio.InvalidProtocolBufferException
/*     */     {
/* 582 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws ppbio.InvalidProtocolBufferException
/*     */     {
/* 588 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiRoleAwardCache copy()
/*     */     {
/* 594 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiRoleAwardCache toData()
/*     */     {
/* 600 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MultiRoleAwardCache toBean()
/*     */     {
/* 605 */       return new MultiRoleAwardCache(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiRoleAwardCache toDataIf()
/*     */     {
/* 611 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MultiRoleAwardCache toBeanIf()
/*     */     {
/* 616 */       return new MultiRoleAwardCache(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 622 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 626 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 630 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 634 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 638 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 642 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 646 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRoles()
/*     */     {
/* 653 */       return this.roles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRolesAsData()
/*     */     {
/* 660 */       return this.roles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Item2CountBean> getAwarditemids()
/*     */     {
/* 667 */       return this.awarditemids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Item2CountBean> getAwarditemidsAsData()
/*     */     {
/* 674 */       return this.awarditemids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getIndexmap()
/*     */     {
/* 681 */       return this.indexmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getIndexmapAsData()
/*     */     {
/* 688 */       return this.indexmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getOperroleids()
/*     */     {
/* 695 */       return this.operroleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getOperroleidsAsData()
/*     */     {
/* 702 */       return this.operroleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public TLogArg getTlogarg()
/*     */     {
/* 709 */       return this.tlogarg;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTlogarg(TLogArg _v_)
/*     */     {
/* 716 */       this.tlogarg = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 722 */       if (!(_o1_ instanceof Data)) return false;
/* 723 */       Data _o_ = (Data)_o1_;
/* 724 */       if (!this.roles.equals(_o_.roles)) return false;
/* 725 */       if (!this.awarditemids.equals(_o_.awarditemids)) return false;
/* 726 */       if (!this.indexmap.equals(_o_.indexmap)) return false;
/* 727 */       if (!this.operroleids.equals(_o_.operroleids)) return false;
/* 728 */       if (((null == this.tlogarg) && (null != _o_.tlogarg)) || ((null != this.tlogarg) && (null == _o_.tlogarg)) || ((null != this.tlogarg) && (null != _o_.tlogarg) && (!this.tlogarg.equals(_o_.tlogarg)))) return false;
/* 729 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 735 */       int _h_ = 0;
/* 736 */       _h_ += this.roles.hashCode();
/* 737 */       _h_ += this.awarditemids.hashCode();
/* 738 */       _h_ += this.indexmap.hashCode();
/* 739 */       _h_ += this.operroleids.hashCode();
/* 740 */       _h_ += (this.tlogarg == null ? 0 : this.tlogarg.hashCode());
/* 741 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 747 */       StringBuilder _sb_ = new StringBuilder();
/* 748 */       _sb_.append("(");
/* 749 */       _sb_.append(this.roles);
/* 750 */       _sb_.append(",");
/* 751 */       _sb_.append(this.awarditemids);
/* 752 */       _sb_.append(",");
/* 753 */       _sb_.append(this.indexmap);
/* 754 */       _sb_.append(",");
/* 755 */       _sb_.append(this.operroleids);
/* 756 */       _sb_.append(",");
/* 757 */       _sb_.append(this.tlogarg);
/* 758 */       _sb_.append(")");
/* 759 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MultiRoleAwardCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */