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
/*      */ public final class Active extends XBean implements xbean.Active
/*      */ {
/*      */   private HashMap<Integer, Integer> activitymap;
/*      */   private SetX<Integer> awardcfgids;
/*      */   private long resettime;
/*      */   private SetX<Integer> award_index_id_set;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.activitymap.clear();
/*   25 */     this.awardcfgids.clear();
/*   26 */     this.resettime = 0L;
/*   27 */     this.award_index_id_set.clear();
/*      */   }
/*      */   
/*      */   Active(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.activitymap = new HashMap();
/*   34 */     this.awardcfgids = new SetX();
/*   35 */     this.award_index_id_set = new SetX();
/*      */   }
/*      */   
/*      */   public Active()
/*      */   {
/*   40 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Active(Active _o_)
/*      */   {
/*   45 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Active(xbean.Active _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   50 */     super(_xp_, _vn_);
/*   51 */     if ((_o1_ instanceof Active)) { assign((Active)_o1_);
/*   52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   54 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Active _o_) {
/*   59 */     _o_._xdb_verify_unsafe_();
/*   60 */     this.activitymap = new HashMap();
/*   61 */     for (Map.Entry<Integer, Integer> _e_ : _o_.activitymap.entrySet())
/*   62 */       this.activitymap.put(_e_.getKey(), _e_.getValue());
/*   63 */     this.awardcfgids = new SetX();
/*   64 */     this.awardcfgids.addAll(_o_.awardcfgids);
/*   65 */     this.resettime = _o_.resettime;
/*   66 */     this.award_index_id_set = new SetX();
/*   67 */     this.award_index_id_set.addAll(_o_.award_index_id_set);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   72 */     this.activitymap = new HashMap();
/*   73 */     for (Map.Entry<Integer, Integer> _e_ : _o_.activitymap.entrySet())
/*   74 */       this.activitymap.put(_e_.getKey(), _e_.getValue());
/*   75 */     this.awardcfgids = new SetX();
/*   76 */     this.awardcfgids.addAll(_o_.awardcfgids);
/*   77 */     this.resettime = _o_.resettime;
/*   78 */     this.award_index_id_set = new SetX();
/*   79 */     this.award_index_id_set.addAll(_o_.award_index_id_set);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   85 */     _xdb_verify_unsafe_();
/*   86 */     _os_.compact_uint32(this.activitymap.size());
/*   87 */     for (Map.Entry<Integer, Integer> _e_ : this.activitymap.entrySet())
/*      */     {
/*   89 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   90 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*   92 */     _os_.compact_uint32(this.awardcfgids.size());
/*   93 */     for (Integer _v_ : this.awardcfgids)
/*      */     {
/*   95 */       _os_.marshal(_v_.intValue());
/*      */     }
/*   97 */     _os_.marshal(this.resettime);
/*   98 */     _os_.compact_uint32(this.award_index_id_set.size());
/*   99 */     for (Integer _v_ : this.award_index_id_set)
/*      */     {
/*  101 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  103 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  109 */     _xdb_verify_unsafe_();
/*      */     
/*  111 */     int size = _os_.uncompact_uint32();
/*  112 */     if (size >= 12)
/*      */     {
/*  114 */       this.activitymap = new HashMap(size * 2);
/*      */     }
/*  116 */     for (; size > 0; size--)
/*      */     {
/*  118 */       int _k_ = 0;
/*  119 */       _k_ = _os_.unmarshal_int();
/*  120 */       int _v_ = 0;
/*  121 */       _v_ = _os_.unmarshal_int();
/*  122 */       this.activitymap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  125 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  127 */       int _v_ = 0;
/*  128 */       _v_ = _os_.unmarshal_int();
/*  129 */       this.awardcfgids.add(Integer.valueOf(_v_));
/*      */     }
/*  131 */     this.resettime = _os_.unmarshal_long();
/*  132 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  134 */       int _v_ = 0;
/*  135 */       _v_ = _os_.unmarshal_int();
/*  136 */       this.award_index_id_set.add(Integer.valueOf(_v_));
/*      */     }
/*  138 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*  145 */     int _size_ = 0;
/*  146 */     for (Map.Entry<Integer, Integer> _e_ : this.activitymap.entrySet())
/*      */     {
/*  148 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  149 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  151 */     for (Integer _v_ : this.awardcfgids)
/*      */     {
/*  153 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */     }
/*  155 */     _size_ += CodedOutputStream.computeInt64Size(3, this.resettime);
/*  156 */     for (Integer _v_ : this.award_index_id_set)
/*      */     {
/*  158 */       _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
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
/*  169 */       for (Map.Entry<Integer, Integer> _e_ : this.activitymap.entrySet())
/*      */       {
/*  171 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  172 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  174 */       for (Integer _v_ : this.awardcfgids)
/*      */       {
/*  176 */         _output_.writeInt32(2, _v_.intValue());
/*      */       }
/*  178 */       _output_.writeInt64(3, this.resettime);
/*  179 */       for (Integer _v_ : this.award_index_id_set)
/*      */       {
/*  181 */         _output_.writeInt32(4, _v_.intValue());
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
/*  210 */           int _k_ = 0;
/*  211 */           _k_ = _input_.readInt32();
/*  212 */           int readTag = _input_.readTag();
/*  213 */           if (8 != readTag)
/*      */           {
/*  215 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  217 */           int _v_ = 0;
/*  218 */           _v_ = _input_.readInt32();
/*  219 */           this.activitymap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  220 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  224 */           int _v_ = 0;
/*  225 */           _v_ = _input_.readInt32();
/*  226 */           this.awardcfgids.add(Integer.valueOf(_v_));
/*  227 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  231 */           this.resettime = _input_.readInt64();
/*  232 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  236 */           int _v_ = 0;
/*  237 */           _v_ = _input_.readInt32();
/*  238 */           this.award_index_id_set.add(Integer.valueOf(_v_));
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
/*      */   public xbean.Active copy()
/*      */   {
/*  266 */     _xdb_verify_unsafe_();
/*  267 */     return new Active(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Active toData()
/*      */   {
/*  273 */     _xdb_verify_unsafe_();
/*  274 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Active toBean()
/*      */   {
/*  279 */     _xdb_verify_unsafe_();
/*  280 */     return new Active(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Active toDataIf()
/*      */   {
/*  286 */     _xdb_verify_unsafe_();
/*  287 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Active toBeanIf()
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
/*      */   public Map<Integer, Integer> getActivitymap()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return xdb.Logs.logMap(new xdb.LogKey(this, "activitymap"), this.activitymap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getActivitymapAsData()
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*      */     
/*  317 */     Active _o_ = this;
/*  318 */     Map<Integer, Integer> activitymap = new HashMap();
/*  319 */     for (Map.Entry<Integer, Integer> _e_ : _o_.activitymap.entrySet())
/*  320 */       activitymap.put(_e_.getKey(), _e_.getValue());
/*  321 */     return activitymap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getAwardcfgids()
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     return xdb.Logs.logSet(new xdb.LogKey(this, "awardcfgids"), this.awardcfgids);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getAwardcfgidsAsData()
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*      */     
/*  337 */     Active _o_ = this;
/*  338 */     Set<Integer> awardcfgids = new SetX();
/*  339 */     awardcfgids.addAll(_o_.awardcfgids);
/*  340 */     return awardcfgids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getResettime()
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*  348 */     return this.resettime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getAward_index_id_set()
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     return xdb.Logs.logSet(new xdb.LogKey(this, "award_index_id_set"), this.award_index_id_set);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getAward_index_id_setAsData()
/*      */   {
/*  362 */     _xdb_verify_unsafe_();
/*      */     
/*  364 */     Active _o_ = this;
/*  365 */     Set<Integer> award_index_id_set = new SetX();
/*  366 */     award_index_id_set.addAll(_o_.award_index_id_set);
/*  367 */     return award_index_id_set;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setResettime(long _v_)
/*      */   {
/*  374 */     _xdb_verify_unsafe_();
/*  375 */     xdb.Logs.logIf(new xdb.LogKey(this, "resettime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  379 */         new xdb.logs.LogLong(this, Active.this.resettime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  383 */             Active.this.resettime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  387 */     });
/*  388 */     this.resettime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  394 */     _xdb_verify_unsafe_();
/*  395 */     Active _o_ = null;
/*  396 */     if ((_o1_ instanceof Active)) { _o_ = (Active)_o1_;
/*  397 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  398 */       return false;
/*  399 */     if (!this.activitymap.equals(_o_.activitymap)) return false;
/*  400 */     if (!this.awardcfgids.equals(_o_.awardcfgids)) return false;
/*  401 */     if (this.resettime != _o_.resettime) return false;
/*  402 */     if (!this.award_index_id_set.equals(_o_.award_index_id_set)) return false;
/*  403 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     int _h_ = 0;
/*  411 */     _h_ += this.activitymap.hashCode();
/*  412 */     _h_ += this.awardcfgids.hashCode();
/*  413 */     _h_ = (int)(_h_ + this.resettime);
/*  414 */     _h_ += this.award_index_id_set.hashCode();
/*  415 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  421 */     _xdb_verify_unsafe_();
/*  422 */     StringBuilder _sb_ = new StringBuilder();
/*  423 */     _sb_.append("(");
/*  424 */     _sb_.append(this.activitymap);
/*  425 */     _sb_.append(",");
/*  426 */     _sb_.append(this.awardcfgids);
/*  427 */     _sb_.append(",");
/*  428 */     _sb_.append(this.resettime);
/*  429 */     _sb_.append(",");
/*  430 */     _sb_.append(this.award_index_id_set);
/*  431 */     _sb_.append(")");
/*  432 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  438 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  439 */     lb.add(new xdb.logs.ListenableMap().setVarName("activitymap"));
/*  440 */     lb.add(new xdb.logs.ListenableSet().setVarName("awardcfgids"));
/*  441 */     lb.add(new xdb.logs.ListenableChanged().setVarName("resettime"));
/*  442 */     lb.add(new xdb.logs.ListenableSet().setVarName("award_index_id_set"));
/*  443 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Active {
/*      */     private Const() {}
/*      */     
/*      */     Active nThis() {
/*  450 */       return Active.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  456 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Active copy()
/*      */     {
/*  462 */       return Active.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Active toData()
/*      */     {
/*  468 */       return Active.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Active toBean()
/*      */     {
/*  473 */       return Active.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Active toDataIf()
/*      */     {
/*  479 */       return Active.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Active toBeanIf()
/*      */     {
/*  484 */       return Active.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getActivitymap()
/*      */     {
/*  491 */       Active.this._xdb_verify_unsafe_();
/*  492 */       return xdb.Consts.constMap(Active.this.activitymap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getActivitymapAsData()
/*      */     {
/*  499 */       Active.this._xdb_verify_unsafe_();
/*      */       
/*  501 */       Active _o_ = Active.this;
/*  502 */       Map<Integer, Integer> activitymap = new HashMap();
/*  503 */       for (Map.Entry<Integer, Integer> _e_ : _o_.activitymap.entrySet())
/*  504 */         activitymap.put(_e_.getKey(), _e_.getValue());
/*  505 */       return activitymap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getAwardcfgids()
/*      */     {
/*  512 */       Active.this._xdb_verify_unsafe_();
/*  513 */       return xdb.Consts.constSet(Active.this.awardcfgids);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getAwardcfgidsAsData()
/*      */     {
/*  519 */       Active.this._xdb_verify_unsafe_();
/*      */       
/*  521 */       Active _o_ = Active.this;
/*  522 */       Set<Integer> awardcfgids = new SetX();
/*  523 */       awardcfgids.addAll(_o_.awardcfgids);
/*  524 */       return awardcfgids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getResettime()
/*      */     {
/*  531 */       Active.this._xdb_verify_unsafe_();
/*  532 */       return Active.this.resettime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getAward_index_id_set()
/*      */     {
/*  539 */       Active.this._xdb_verify_unsafe_();
/*  540 */       return xdb.Consts.constSet(Active.this.award_index_id_set);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getAward_index_id_setAsData()
/*      */     {
/*  546 */       Active.this._xdb_verify_unsafe_();
/*      */       
/*  548 */       Active _o_ = Active.this;
/*  549 */       Set<Integer> award_index_id_set = new SetX();
/*  550 */       award_index_id_set.addAll(_o_.award_index_id_set);
/*  551 */       return award_index_id_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setResettime(long _v_)
/*      */     {
/*  558 */       Active.this._xdb_verify_unsafe_();
/*  559 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  565 */       Active.this._xdb_verify_unsafe_();
/*  566 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  572 */       Active.this._xdb_verify_unsafe_();
/*  573 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  579 */       return Active.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  585 */       return Active.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  591 */       Active.this._xdb_verify_unsafe_();
/*  592 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  598 */       return Active.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  604 */       return Active.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  610 */       Active.this._xdb_verify_unsafe_();
/*  611 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  617 */       return Active.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  623 */       return Active.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  629 */       return Active.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  635 */       return Active.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  641 */       return Active.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  647 */       return Active.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  653 */       return Active.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Active
/*      */   {
/*      */     private HashMap<Integer, Integer> activitymap;
/*      */     
/*      */     private HashSet<Integer> awardcfgids;
/*      */     
/*      */     private long resettime;
/*      */     
/*      */     private HashSet<Integer> award_index_id_set;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  671 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  676 */       this.activitymap = new HashMap();
/*  677 */       this.awardcfgids = new HashSet();
/*  678 */       this.award_index_id_set = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.Active _o1_)
/*      */     {
/*  683 */       if ((_o1_ instanceof Active)) { assign((Active)_o1_);
/*  684 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  685 */       } else if ((_o1_ instanceof Active.Const)) assign(((Active.Const)_o1_).nThis()); else {
/*  686 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Active _o_) {
/*  691 */       this.activitymap = new HashMap();
/*  692 */       for (Map.Entry<Integer, Integer> _e_ : _o_.activitymap.entrySet())
/*  693 */         this.activitymap.put(_e_.getKey(), _e_.getValue());
/*  694 */       this.awardcfgids = new HashSet();
/*  695 */       this.awardcfgids.addAll(_o_.awardcfgids);
/*  696 */       this.resettime = _o_.resettime;
/*  697 */       this.award_index_id_set = new HashSet();
/*  698 */       this.award_index_id_set.addAll(_o_.award_index_id_set);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  703 */       this.activitymap = new HashMap();
/*  704 */       for (Map.Entry<Integer, Integer> _e_ : _o_.activitymap.entrySet())
/*  705 */         this.activitymap.put(_e_.getKey(), _e_.getValue());
/*  706 */       this.awardcfgids = new HashSet();
/*  707 */       this.awardcfgids.addAll(_o_.awardcfgids);
/*  708 */       this.resettime = _o_.resettime;
/*  709 */       this.award_index_id_set = new HashSet();
/*  710 */       this.award_index_id_set.addAll(_o_.award_index_id_set);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  716 */       _os_.compact_uint32(this.activitymap.size());
/*  717 */       for (Map.Entry<Integer, Integer> _e_ : this.activitymap.entrySet())
/*      */       {
/*  719 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  720 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  722 */       _os_.compact_uint32(this.awardcfgids.size());
/*  723 */       for (Integer _v_ : this.awardcfgids)
/*      */       {
/*  725 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  727 */       _os_.marshal(this.resettime);
/*  728 */       _os_.compact_uint32(this.award_index_id_set.size());
/*  729 */       for (Integer _v_ : this.award_index_id_set)
/*      */       {
/*  731 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  733 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  740 */       int size = _os_.uncompact_uint32();
/*  741 */       if (size >= 12)
/*      */       {
/*  743 */         this.activitymap = new HashMap(size * 2);
/*      */       }
/*  745 */       for (; size > 0; size--)
/*      */       {
/*  747 */         int _k_ = 0;
/*  748 */         _k_ = _os_.unmarshal_int();
/*  749 */         int _v_ = 0;
/*  750 */         _v_ = _os_.unmarshal_int();
/*  751 */         this.activitymap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  754 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  756 */         int _v_ = 0;
/*  757 */         _v_ = _os_.unmarshal_int();
/*  758 */         this.awardcfgids.add(Integer.valueOf(_v_));
/*      */       }
/*  760 */       this.resettime = _os_.unmarshal_long();
/*  761 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  763 */         int _v_ = 0;
/*  764 */         _v_ = _os_.unmarshal_int();
/*  765 */         this.award_index_id_set.add(Integer.valueOf(_v_));
/*      */       }
/*  767 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  773 */       int _size_ = 0;
/*  774 */       for (Map.Entry<Integer, Integer> _e_ : this.activitymap.entrySet())
/*      */       {
/*  776 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  777 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  779 */       for (Integer _v_ : this.awardcfgids)
/*      */       {
/*  781 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */       }
/*  783 */       _size_ += CodedOutputStream.computeInt64Size(3, this.resettime);
/*  784 */       for (Integer _v_ : this.award_index_id_set)
/*      */       {
/*  786 */         _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*      */       }
/*  788 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  796 */         for (Map.Entry<Integer, Integer> _e_ : this.activitymap.entrySet())
/*      */         {
/*  798 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  799 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  801 */         for (Integer _v_ : this.awardcfgids)
/*      */         {
/*  803 */           _output_.writeInt32(2, _v_.intValue());
/*      */         }
/*  805 */         _output_.writeInt64(3, this.resettime);
/*  806 */         for (Integer _v_ : this.award_index_id_set)
/*      */         {
/*  808 */           _output_.writeInt32(4, _v_.intValue());
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
/*  836 */             int _k_ = 0;
/*  837 */             _k_ = _input_.readInt32();
/*  838 */             int readTag = _input_.readTag();
/*  839 */             if (8 != readTag)
/*      */             {
/*  841 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  843 */             int _v_ = 0;
/*  844 */             _v_ = _input_.readInt32();
/*  845 */             this.activitymap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  846 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  850 */             int _v_ = 0;
/*  851 */             _v_ = _input_.readInt32();
/*  852 */             this.awardcfgids.add(Integer.valueOf(_v_));
/*  853 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  857 */             this.resettime = _input_.readInt64();
/*  858 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  862 */             int _v_ = 0;
/*  863 */             _v_ = _input_.readInt32();
/*  864 */             this.award_index_id_set.add(Integer.valueOf(_v_));
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
/*      */     public xbean.Active copy()
/*      */     {
/*  892 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Active toData()
/*      */     {
/*  898 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Active toBean()
/*      */     {
/*  903 */       return new Active(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Active toDataIf()
/*      */     {
/*  909 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Active toBeanIf()
/*      */     {
/*  914 */       return new Active(this, null, null);
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
/*      */     public Map<Integer, Integer> getActivitymap()
/*      */     {
/*  951 */       return this.activitymap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getActivitymapAsData()
/*      */     {
/*  958 */       return this.activitymap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getAwardcfgids()
/*      */     {
/*  965 */       return this.awardcfgids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getAwardcfgidsAsData()
/*      */     {
/*  972 */       return this.awardcfgids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getResettime()
/*      */     {
/*  979 */       return this.resettime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getAward_index_id_set()
/*      */     {
/*  986 */       return this.award_index_id_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getAward_index_id_setAsData()
/*      */     {
/*  993 */       return this.award_index_id_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setResettime(long _v_)
/*      */     {
/* 1000 */       this.resettime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1006 */       if (!(_o1_ instanceof Data)) return false;
/* 1007 */       Data _o_ = (Data)_o1_;
/* 1008 */       if (!this.activitymap.equals(_o_.activitymap)) return false;
/* 1009 */       if (!this.awardcfgids.equals(_o_.awardcfgids)) return false;
/* 1010 */       if (this.resettime != _o_.resettime) return false;
/* 1011 */       if (!this.award_index_id_set.equals(_o_.award_index_id_set)) return false;
/* 1012 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1018 */       int _h_ = 0;
/* 1019 */       _h_ += this.activitymap.hashCode();
/* 1020 */       _h_ += this.awardcfgids.hashCode();
/* 1021 */       _h_ = (int)(_h_ + this.resettime);
/* 1022 */       _h_ += this.award_index_id_set.hashCode();
/* 1023 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1029 */       StringBuilder _sb_ = new StringBuilder();
/* 1030 */       _sb_.append("(");
/* 1031 */       _sb_.append(this.activitymap);
/* 1032 */       _sb_.append(",");
/* 1033 */       _sb_.append(this.awardcfgids);
/* 1034 */       _sb_.append(",");
/* 1035 */       _sb_.append(this.resettime);
/* 1036 */       _sb_.append(",");
/* 1037 */       _sb_.append(this.award_index_id_set);
/* 1038 */       _sb_.append(")");
/* 1039 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Active.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */