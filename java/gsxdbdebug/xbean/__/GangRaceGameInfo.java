/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.XBean;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class GangRaceGameInfo extends XBean implements xbean.GangRaceGameInfo
/*      */ {
/*      */   private int gameid;
/*      */   private SetX<Long> curgameroleids;
/*      */   private SetX<Long> allroleids;
/*      */   private HashMap<Integer, Integer> raceid2money;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.gameid = 0;
/*   25 */     this.curgameroleids.clear();
/*   26 */     this.allroleids.clear();
/*   27 */     this.raceid2money.clear();
/*      */   }
/*      */   
/*      */   GangRaceGameInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.curgameroleids = new SetX();
/*   34 */     this.allroleids = new SetX();
/*   35 */     this.raceid2money = new HashMap();
/*      */   }
/*      */   
/*      */   public GangRaceGameInfo()
/*      */   {
/*   40 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public GangRaceGameInfo(GangRaceGameInfo _o_)
/*      */   {
/*   45 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   GangRaceGameInfo(xbean.GangRaceGameInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   50 */     super(_xp_, _vn_);
/*   51 */     if ((_o1_ instanceof GangRaceGameInfo)) { assign((GangRaceGameInfo)_o1_);
/*   52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   54 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(GangRaceGameInfo _o_) {
/*   59 */     _o_._xdb_verify_unsafe_();
/*   60 */     this.gameid = _o_.gameid;
/*   61 */     this.curgameroleids = new SetX();
/*   62 */     this.curgameroleids.addAll(_o_.curgameroleids);
/*   63 */     this.allroleids = new SetX();
/*   64 */     this.allroleids.addAll(_o_.allroleids);
/*   65 */     this.raceid2money = new HashMap();
/*   66 */     for (Map.Entry<Integer, Integer> _e_ : _o_.raceid2money.entrySet()) {
/*   67 */       this.raceid2money.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   72 */     this.gameid = _o_.gameid;
/*   73 */     this.curgameroleids = new SetX();
/*   74 */     this.curgameroleids.addAll(_o_.curgameroleids);
/*   75 */     this.allroleids = new SetX();
/*   76 */     this.allroleids.addAll(_o_.allroleids);
/*   77 */     this.raceid2money = new HashMap();
/*   78 */     for (Map.Entry<Integer, Integer> _e_ : _o_.raceid2money.entrySet()) {
/*   79 */       this.raceid2money.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   85 */     _xdb_verify_unsafe_();
/*   86 */     _os_.marshal(this.gameid);
/*   87 */     _os_.compact_uint32(this.curgameroleids.size());
/*   88 */     for (Long _v_ : this.curgameroleids)
/*      */     {
/*   90 */       _os_.marshal(_v_.longValue());
/*      */     }
/*   92 */     _os_.compact_uint32(this.allroleids.size());
/*   93 */     for (Long _v_ : this.allroleids)
/*      */     {
/*   95 */       _os_.marshal(_v_.longValue());
/*      */     }
/*   97 */     _os_.compact_uint32(this.raceid2money.size());
/*   98 */     for (Map.Entry<Integer, Integer> _e_ : this.raceid2money.entrySet())
/*      */     {
/*  100 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  101 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  103 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  109 */     _xdb_verify_unsafe_();
/*  110 */     this.gameid = _os_.unmarshal_int();
/*  111 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  113 */       long _v_ = 0L;
/*  114 */       _v_ = _os_.unmarshal_long();
/*  115 */       this.curgameroleids.add(Long.valueOf(_v_));
/*      */     }
/*  117 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  119 */       long _v_ = 0L;
/*  120 */       _v_ = _os_.unmarshal_long();
/*  121 */       this.allroleids.add(Long.valueOf(_v_));
/*      */     }
/*      */     
/*  124 */     int size = _os_.uncompact_uint32();
/*  125 */     if (size >= 12)
/*      */     {
/*  127 */       this.raceid2money = new HashMap(size * 2);
/*      */     }
/*  129 */     for (; size > 0; size--)
/*      */     {
/*  131 */       int _k_ = 0;
/*  132 */       _k_ = _os_.unmarshal_int();
/*  133 */       int _v_ = 0;
/*  134 */       _v_ = _os_.unmarshal_int();
/*  135 */       this.raceid2money.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  138 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*  145 */     int _size_ = 0;
/*  146 */     _size_ += CodedOutputStream.computeInt32Size(1, this.gameid);
/*  147 */     for (Long _v_ : this.curgameroleids)
/*      */     {
/*  149 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */     }
/*  151 */     for (Long _v_ : this.allroleids)
/*      */     {
/*  153 */       _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*      */     }
/*  155 */     for (Map.Entry<Integer, Integer> _e_ : this.raceid2money.entrySet())
/*      */     {
/*  157 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  158 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  160 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  166 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  169 */       _output_.writeInt32(1, this.gameid);
/*  170 */       for (Long _v_ : this.curgameroleids)
/*      */       {
/*  172 */         _output_.writeInt64(2, _v_.longValue());
/*      */       }
/*  174 */       for (Long _v_ : this.allroleids)
/*      */       {
/*  176 */         _output_.writeInt64(3, _v_.longValue());
/*      */       }
/*  178 */       for (Map.Entry<Integer, Integer> _e_ : this.raceid2money.entrySet())
/*      */       {
/*  180 */         _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  181 */         _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  186 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  188 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  194 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  197 */       boolean done = false;
/*  198 */       while (!done)
/*      */       {
/*  200 */         int tag = _input_.readTag();
/*  201 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  205 */           done = true;
/*  206 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  210 */           this.gameid = _input_.readInt32();
/*  211 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  215 */           long _v_ = 0L;
/*  216 */           _v_ = _input_.readInt64();
/*  217 */           this.curgameroleids.add(Long.valueOf(_v_));
/*  218 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  222 */           long _v_ = 0L;
/*  223 */           _v_ = _input_.readInt64();
/*  224 */           this.allroleids.add(Long.valueOf(_v_));
/*  225 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  229 */           int _k_ = 0;
/*  230 */           _k_ = _input_.readInt32();
/*  231 */           int readTag = _input_.readTag();
/*  232 */           if (32 != readTag)
/*      */           {
/*  234 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  236 */           int _v_ = 0;
/*  237 */           _v_ = _input_.readInt32();
/*  238 */           this.raceid2money.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  239 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  243 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  245 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  254 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  258 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  260 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GangRaceGameInfo copy()
/*      */   {
/*  266 */     _xdb_verify_unsafe_();
/*  267 */     return new GangRaceGameInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GangRaceGameInfo toData()
/*      */   {
/*  273 */     _xdb_verify_unsafe_();
/*  274 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.GangRaceGameInfo toBean()
/*      */   {
/*  279 */     _xdb_verify_unsafe_();
/*  280 */     return new GangRaceGameInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GangRaceGameInfo toDataIf()
/*      */   {
/*  286 */     _xdb_verify_unsafe_();
/*  287 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.GangRaceGameInfo toBeanIf()
/*      */   {
/*  292 */     _xdb_verify_unsafe_();
/*  293 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  299 */     _xdb_verify_unsafe_();
/*  300 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGameid()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return this.gameid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getCurgameroleids()
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*  316 */     return xdb.Logs.logSet(new xdb.LogKey(this, "curgameroleids"), this.curgameroleids);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getCurgameroleidsAsData()
/*      */   {
/*  322 */     _xdb_verify_unsafe_();
/*      */     
/*  324 */     GangRaceGameInfo _o_ = this;
/*  325 */     Set<Long> curgameroleids = new SetX();
/*  326 */     curgameroleids.addAll(_o_.curgameroleids);
/*  327 */     return curgameroleids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getAllroleids()
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     return xdb.Logs.logSet(new xdb.LogKey(this, "allroleids"), this.allroleids);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getAllroleidsAsData()
/*      */   {
/*  341 */     _xdb_verify_unsafe_();
/*      */     
/*  343 */     GangRaceGameInfo _o_ = this;
/*  344 */     Set<Long> allroleids = new SetX();
/*  345 */     allroleids.addAll(_o_.allroleids);
/*  346 */     return allroleids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getRaceid2money()
/*      */   {
/*  353 */     _xdb_verify_unsafe_();
/*  354 */     return xdb.Logs.logMap(new xdb.LogKey(this, "raceid2money"), this.raceid2money);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getRaceid2moneyAsData()
/*      */   {
/*  361 */     _xdb_verify_unsafe_();
/*      */     
/*  363 */     GangRaceGameInfo _o_ = this;
/*  364 */     Map<Integer, Integer> raceid2money = new HashMap();
/*  365 */     for (Map.Entry<Integer, Integer> _e_ : _o_.raceid2money.entrySet())
/*  366 */       raceid2money.put(_e_.getKey(), _e_.getValue());
/*  367 */     return raceid2money;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGameid(int _v_)
/*      */   {
/*  374 */     _xdb_verify_unsafe_();
/*  375 */     xdb.Logs.logIf(new xdb.LogKey(this, "gameid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  379 */         new xdb.logs.LogInt(this, GangRaceGameInfo.this.gameid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  383 */             GangRaceGameInfo.this.gameid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  387 */     });
/*  388 */     this.gameid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  394 */     _xdb_verify_unsafe_();
/*  395 */     GangRaceGameInfo _o_ = null;
/*  396 */     if ((_o1_ instanceof GangRaceGameInfo)) { _o_ = (GangRaceGameInfo)_o1_;
/*  397 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  398 */       return false;
/*  399 */     if (this.gameid != _o_.gameid) return false;
/*  400 */     if (!this.curgameroleids.equals(_o_.curgameroleids)) return false;
/*  401 */     if (!this.allroleids.equals(_o_.allroleids)) return false;
/*  402 */     if (!this.raceid2money.equals(_o_.raceid2money)) return false;
/*  403 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     int _h_ = 0;
/*  411 */     _h_ += this.gameid;
/*  412 */     _h_ += this.curgameroleids.hashCode();
/*  413 */     _h_ += this.allroleids.hashCode();
/*  414 */     _h_ += this.raceid2money.hashCode();
/*  415 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  421 */     _xdb_verify_unsafe_();
/*  422 */     StringBuilder _sb_ = new StringBuilder();
/*  423 */     _sb_.append("(");
/*  424 */     _sb_.append(this.gameid);
/*  425 */     _sb_.append(",");
/*  426 */     _sb_.append(this.curgameroleids);
/*  427 */     _sb_.append(",");
/*  428 */     _sb_.append(this.allroleids);
/*  429 */     _sb_.append(",");
/*  430 */     _sb_.append(this.raceid2money);
/*  431 */     _sb_.append(")");
/*  432 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  438 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  439 */     lb.add(new xdb.logs.ListenableChanged().setVarName("gameid"));
/*  440 */     lb.add(new xdb.logs.ListenableSet().setVarName("curgameroleids"));
/*  441 */     lb.add(new xdb.logs.ListenableSet().setVarName("allroleids"));
/*  442 */     lb.add(new xdb.logs.ListenableMap().setVarName("raceid2money"));
/*  443 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.GangRaceGameInfo {
/*      */     private Const() {}
/*      */     
/*      */     GangRaceGameInfo nThis() {
/*  450 */       return GangRaceGameInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  456 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangRaceGameInfo copy()
/*      */     {
/*  462 */       return GangRaceGameInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangRaceGameInfo toData()
/*      */     {
/*  468 */       return GangRaceGameInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.GangRaceGameInfo toBean()
/*      */     {
/*  473 */       return GangRaceGameInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangRaceGameInfo toDataIf()
/*      */     {
/*  479 */       return GangRaceGameInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.GangRaceGameInfo toBeanIf()
/*      */     {
/*  484 */       return GangRaceGameInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGameid()
/*      */     {
/*  491 */       GangRaceGameInfo.this._xdb_verify_unsafe_();
/*  492 */       return GangRaceGameInfo.this.gameid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCurgameroleids()
/*      */     {
/*  499 */       GangRaceGameInfo.this._xdb_verify_unsafe_();
/*  500 */       return xdb.Consts.constSet(GangRaceGameInfo.this.curgameroleids);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getCurgameroleidsAsData()
/*      */     {
/*  506 */       GangRaceGameInfo.this._xdb_verify_unsafe_();
/*      */       
/*  508 */       GangRaceGameInfo _o_ = GangRaceGameInfo.this;
/*  509 */       Set<Long> curgameroleids = new SetX();
/*  510 */       curgameroleids.addAll(_o_.curgameroleids);
/*  511 */       return curgameroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getAllroleids()
/*      */     {
/*  518 */       GangRaceGameInfo.this._xdb_verify_unsafe_();
/*  519 */       return xdb.Consts.constSet(GangRaceGameInfo.this.allroleids);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getAllroleidsAsData()
/*      */     {
/*  525 */       GangRaceGameInfo.this._xdb_verify_unsafe_();
/*      */       
/*  527 */       GangRaceGameInfo _o_ = GangRaceGameInfo.this;
/*  528 */       Set<Long> allroleids = new SetX();
/*  529 */       allroleids.addAll(_o_.allroleids);
/*  530 */       return allroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getRaceid2money()
/*      */     {
/*  537 */       GangRaceGameInfo.this._xdb_verify_unsafe_();
/*  538 */       return xdb.Consts.constMap(GangRaceGameInfo.this.raceid2money);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getRaceid2moneyAsData()
/*      */     {
/*  545 */       GangRaceGameInfo.this._xdb_verify_unsafe_();
/*      */       
/*  547 */       GangRaceGameInfo _o_ = GangRaceGameInfo.this;
/*  548 */       Map<Integer, Integer> raceid2money = new HashMap();
/*  549 */       for (Map.Entry<Integer, Integer> _e_ : _o_.raceid2money.entrySet())
/*  550 */         raceid2money.put(_e_.getKey(), _e_.getValue());
/*  551 */       return raceid2money;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGameid(int _v_)
/*      */     {
/*  558 */       GangRaceGameInfo.this._xdb_verify_unsafe_();
/*  559 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  565 */       GangRaceGameInfo.this._xdb_verify_unsafe_();
/*  566 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  572 */       GangRaceGameInfo.this._xdb_verify_unsafe_();
/*  573 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  579 */       return GangRaceGameInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  585 */       return GangRaceGameInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  591 */       GangRaceGameInfo.this._xdb_verify_unsafe_();
/*  592 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  598 */       return GangRaceGameInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  604 */       return GangRaceGameInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  610 */       GangRaceGameInfo.this._xdb_verify_unsafe_();
/*  611 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  617 */       return GangRaceGameInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  623 */       return GangRaceGameInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  629 */       return GangRaceGameInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  635 */       return GangRaceGameInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  641 */       return GangRaceGameInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  647 */       return GangRaceGameInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  653 */       return GangRaceGameInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.GangRaceGameInfo
/*      */   {
/*      */     private int gameid;
/*      */     
/*      */     private HashSet<Long> curgameroleids;
/*      */     
/*      */     private HashSet<Long> allroleids;
/*      */     
/*      */     private HashMap<Integer, Integer> raceid2money;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  671 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  676 */       this.curgameroleids = new HashSet();
/*  677 */       this.allroleids = new HashSet();
/*  678 */       this.raceid2money = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.GangRaceGameInfo _o1_)
/*      */     {
/*  683 */       if ((_o1_ instanceof GangRaceGameInfo)) { assign((GangRaceGameInfo)_o1_);
/*  684 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  685 */       } else if ((_o1_ instanceof GangRaceGameInfo.Const)) assign(((GangRaceGameInfo.Const)_o1_).nThis()); else {
/*  686 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(GangRaceGameInfo _o_) {
/*  691 */       this.gameid = _o_.gameid;
/*  692 */       this.curgameroleids = new HashSet();
/*  693 */       this.curgameroleids.addAll(_o_.curgameroleids);
/*  694 */       this.allroleids = new HashSet();
/*  695 */       this.allroleids.addAll(_o_.allroleids);
/*  696 */       this.raceid2money = new HashMap();
/*  697 */       for (Map.Entry<Integer, Integer> _e_ : _o_.raceid2money.entrySet()) {
/*  698 */         this.raceid2money.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  703 */       this.gameid = _o_.gameid;
/*  704 */       this.curgameroleids = new HashSet();
/*  705 */       this.curgameroleids.addAll(_o_.curgameroleids);
/*  706 */       this.allroleids = new HashSet();
/*  707 */       this.allroleids.addAll(_o_.allroleids);
/*  708 */       this.raceid2money = new HashMap();
/*  709 */       for (Map.Entry<Integer, Integer> _e_ : _o_.raceid2money.entrySet()) {
/*  710 */         this.raceid2money.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  716 */       _os_.marshal(this.gameid);
/*  717 */       _os_.compact_uint32(this.curgameroleids.size());
/*  718 */       for (Long _v_ : this.curgameroleids)
/*      */       {
/*  720 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  722 */       _os_.compact_uint32(this.allroleids.size());
/*  723 */       for (Long _v_ : this.allroleids)
/*      */       {
/*  725 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  727 */       _os_.compact_uint32(this.raceid2money.size());
/*  728 */       for (Map.Entry<Integer, Integer> _e_ : this.raceid2money.entrySet())
/*      */       {
/*  730 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  731 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  733 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  739 */       this.gameid = _os_.unmarshal_int();
/*  740 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  742 */         long _v_ = 0L;
/*  743 */         _v_ = _os_.unmarshal_long();
/*  744 */         this.curgameroleids.add(Long.valueOf(_v_));
/*      */       }
/*  746 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  748 */         long _v_ = 0L;
/*  749 */         _v_ = _os_.unmarshal_long();
/*  750 */         this.allroleids.add(Long.valueOf(_v_));
/*      */       }
/*      */       
/*  753 */       int size = _os_.uncompact_uint32();
/*  754 */       if (size >= 12)
/*      */       {
/*  756 */         this.raceid2money = new HashMap(size * 2);
/*      */       }
/*  758 */       for (; size > 0; size--)
/*      */       {
/*  760 */         int _k_ = 0;
/*  761 */         _k_ = _os_.unmarshal_int();
/*  762 */         int _v_ = 0;
/*  763 */         _v_ = _os_.unmarshal_int();
/*  764 */         this.raceid2money.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  767 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  773 */       int _size_ = 0;
/*  774 */       _size_ += CodedOutputStream.computeInt32Size(1, this.gameid);
/*  775 */       for (Long _v_ : this.curgameroleids)
/*      */       {
/*  777 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */       }
/*  779 */       for (Long _v_ : this.allroleids)
/*      */       {
/*  781 */         _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*      */       }
/*  783 */       for (Map.Entry<Integer, Integer> _e_ : this.raceid2money.entrySet())
/*      */       {
/*  785 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  786 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  788 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  796 */         _output_.writeInt32(1, this.gameid);
/*  797 */         for (Long _v_ : this.curgameroleids)
/*      */         {
/*  799 */           _output_.writeInt64(2, _v_.longValue());
/*      */         }
/*  801 */         for (Long _v_ : this.allroleids)
/*      */         {
/*  803 */           _output_.writeInt64(3, _v_.longValue());
/*      */         }
/*  805 */         for (Map.Entry<Integer, Integer> _e_ : this.raceid2money.entrySet())
/*      */         {
/*  807 */           _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  808 */           _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  813 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  815 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  823 */         boolean done = false;
/*  824 */         while (!done)
/*      */         {
/*  826 */           int tag = _input_.readTag();
/*  827 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  831 */             done = true;
/*  832 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  836 */             this.gameid = _input_.readInt32();
/*  837 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  841 */             long _v_ = 0L;
/*  842 */             _v_ = _input_.readInt64();
/*  843 */             this.curgameroleids.add(Long.valueOf(_v_));
/*  844 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  848 */             long _v_ = 0L;
/*  849 */             _v_ = _input_.readInt64();
/*  850 */             this.allroleids.add(Long.valueOf(_v_));
/*  851 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  855 */             int _k_ = 0;
/*  856 */             _k_ = _input_.readInt32();
/*  857 */             int readTag = _input_.readTag();
/*  858 */             if (32 != readTag)
/*      */             {
/*  860 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  862 */             int _v_ = 0;
/*  863 */             _v_ = _input_.readInt32();
/*  864 */             this.raceid2money.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  865 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  869 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  871 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  880 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  884 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  886 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangRaceGameInfo copy()
/*      */     {
/*  892 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangRaceGameInfo toData()
/*      */     {
/*  898 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.GangRaceGameInfo toBean()
/*      */     {
/*  903 */       return new GangRaceGameInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangRaceGameInfo toDataIf()
/*      */     {
/*  909 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.GangRaceGameInfo toBeanIf()
/*      */     {
/*  914 */       return new GangRaceGameInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  920 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  924 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  928 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  932 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  936 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  940 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  944 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGameid()
/*      */     {
/*  951 */       return this.gameid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCurgameroleids()
/*      */     {
/*  958 */       return this.curgameroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCurgameroleidsAsData()
/*      */     {
/*  965 */       return this.curgameroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getAllroleids()
/*      */     {
/*  972 */       return this.allroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getAllroleidsAsData()
/*      */     {
/*  979 */       return this.allroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getRaceid2money()
/*      */     {
/*  986 */       return this.raceid2money;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getRaceid2moneyAsData()
/*      */     {
/*  993 */       return this.raceid2money;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGameid(int _v_)
/*      */     {
/* 1000 */       this.gameid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1006 */       if (!(_o1_ instanceof Data)) return false;
/* 1007 */       Data _o_ = (Data)_o1_;
/* 1008 */       if (this.gameid != _o_.gameid) return false;
/* 1009 */       if (!this.curgameroleids.equals(_o_.curgameroleids)) return false;
/* 1010 */       if (!this.allroleids.equals(_o_.allroleids)) return false;
/* 1011 */       if (!this.raceid2money.equals(_o_.raceid2money)) return false;
/* 1012 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1018 */       int _h_ = 0;
/* 1019 */       _h_ += this.gameid;
/* 1020 */       _h_ += this.curgameroleids.hashCode();
/* 1021 */       _h_ += this.allroleids.hashCode();
/* 1022 */       _h_ += this.raceid2money.hashCode();
/* 1023 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1029 */       StringBuilder _sb_ = new StringBuilder();
/* 1030 */       _sb_.append("(");
/* 1031 */       _sb_.append(this.gameid);
/* 1032 */       _sb_.append(",");
/* 1033 */       _sb_.append(this.curgameroleids);
/* 1034 */       _sb_.append(",");
/* 1035 */       _sb_.append(this.allroleids);
/* 1036 */       _sb_.append(",");
/* 1037 */       _sb_.append(this.raceid2money);
/* 1038 */       _sb_.append(")");
/* 1039 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GangRaceGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */