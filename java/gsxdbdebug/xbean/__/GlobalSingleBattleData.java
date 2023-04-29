/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class GlobalSingleBattleData extends XBean implements xbean.GlobalSingleBattleData
/*      */ {
/*      */   private long world;
/*      */   private long starttime;
/*      */   private HashMap<Integer, xbean.CampInfo> campinfos;
/*      */   private long contextid;
/*      */   private xbean.BattleFightRecord fightrecord;
/*      */   private int battlecfgid;
/*      */   private xbean.SingleBattleResult result;
/*      */   private int stage;
/*      */   private xbean.SingleBattleSessions sessions;
/*      */   private SetX<Long> allfightids;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   36 */     this.world = -1L;
/*   37 */     this.starttime = 0L;
/*   38 */     this.campinfos.clear();
/*   39 */     this.contextid = 0L;
/*   40 */     this.fightrecord._reset_unsafe_();
/*   41 */     this.battlecfgid = 0;
/*   42 */     this.result._reset_unsafe_();
/*   43 */     this.stage = 0;
/*   44 */     this.sessions._reset_unsafe_();
/*   45 */     this.allfightids.clear();
/*      */   }
/*      */   
/*      */   GlobalSingleBattleData(int __, XBean _xp_, String _vn_)
/*      */   {
/*   50 */     super(_xp_, _vn_);
/*   51 */     this.world = -1L;
/*   52 */     this.campinfos = new HashMap();
/*   53 */     this.fightrecord = new BattleFightRecord(0, this, "fightrecord");
/*   54 */     this.result = new SingleBattleResult(0, this, "result");
/*   55 */     this.sessions = new SingleBattleSessions(0, this, "sessions");
/*   56 */     this.allfightids = new SetX();
/*      */   }
/*      */   
/*      */   public GlobalSingleBattleData()
/*      */   {
/*   61 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public GlobalSingleBattleData(GlobalSingleBattleData _o_)
/*      */   {
/*   66 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   GlobalSingleBattleData(xbean.GlobalSingleBattleData _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   71 */     super(_xp_, _vn_);
/*   72 */     if ((_o1_ instanceof GlobalSingleBattleData)) { assign((GlobalSingleBattleData)_o1_);
/*   73 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   74 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   75 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(GlobalSingleBattleData _o_) {
/*   80 */     _o_._xdb_verify_unsafe_();
/*   81 */     this.world = _o_.world;
/*   82 */     this.starttime = _o_.starttime;
/*   83 */     this.campinfos = new HashMap();
/*   84 */     for (Map.Entry<Integer, xbean.CampInfo> _e_ : _o_.campinfos.entrySet())
/*   85 */       this.campinfos.put(_e_.getKey(), new CampInfo((xbean.CampInfo)_e_.getValue(), this, "campinfos"));
/*   86 */     this.contextid = _o_.contextid;
/*   87 */     this.fightrecord = new BattleFightRecord(_o_.fightrecord, this, "fightrecord");
/*   88 */     this.battlecfgid = _o_.battlecfgid;
/*   89 */     this.result = new SingleBattleResult(_o_.result, this, "result");
/*   90 */     this.stage = _o_.stage;
/*   91 */     this.sessions = new SingleBattleSessions(_o_.sessions, this, "sessions");
/*   92 */     this.allfightids = new SetX();
/*   93 */     this.allfightids.addAll(_o_.allfightids);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   98 */     this.world = _o_.world;
/*   99 */     this.starttime = _o_.starttime;
/*  100 */     this.campinfos = new HashMap();
/*  101 */     for (Map.Entry<Integer, xbean.CampInfo> _e_ : _o_.campinfos.entrySet())
/*  102 */       this.campinfos.put(_e_.getKey(), new CampInfo((xbean.CampInfo)_e_.getValue(), this, "campinfos"));
/*  103 */     this.contextid = _o_.contextid;
/*  104 */     this.fightrecord = new BattleFightRecord(_o_.fightrecord, this, "fightrecord");
/*  105 */     this.battlecfgid = _o_.battlecfgid;
/*  106 */     this.result = new SingleBattleResult(_o_.result, this, "result");
/*  107 */     this.stage = _o_.stage;
/*  108 */     this.sessions = new SingleBattleSessions(_o_.sessions, this, "sessions");
/*  109 */     this.allfightids = new SetX();
/*  110 */     this.allfightids.addAll(_o_.allfightids);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  116 */     _xdb_verify_unsafe_();
/*  117 */     _os_.marshal(this.world);
/*  118 */     _os_.marshal(this.starttime);
/*  119 */     _os_.compact_uint32(this.campinfos.size());
/*  120 */     for (Map.Entry<Integer, xbean.CampInfo> _e_ : this.campinfos.entrySet())
/*      */     {
/*  122 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  123 */       ((xbean.CampInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  125 */     _os_.marshal(this.contextid);
/*  126 */     this.fightrecord.marshal(_os_);
/*  127 */     _os_.marshal(this.battlecfgid);
/*  128 */     this.result.marshal(_os_);
/*  129 */     _os_.marshal(this.stage);
/*  130 */     this.sessions.marshal(_os_);
/*  131 */     _os_.compact_uint32(this.allfightids.size());
/*  132 */     for (Long _v_ : this.allfightids)
/*      */     {
/*  134 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  136 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  142 */     _xdb_verify_unsafe_();
/*  143 */     this.world = _os_.unmarshal_long();
/*  144 */     this.starttime = _os_.unmarshal_long();
/*      */     
/*  146 */     int size = _os_.uncompact_uint32();
/*  147 */     if (size >= 12)
/*      */     {
/*  149 */       this.campinfos = new HashMap(size * 2);
/*      */     }
/*  151 */     for (; size > 0; size--)
/*      */     {
/*  153 */       int _k_ = 0;
/*  154 */       _k_ = _os_.unmarshal_int();
/*  155 */       xbean.CampInfo _v_ = new CampInfo(0, this, "campinfos");
/*  156 */       _v_.unmarshal(_os_);
/*  157 */       this.campinfos.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  160 */     this.contextid = _os_.unmarshal_long();
/*  161 */     this.fightrecord.unmarshal(_os_);
/*  162 */     this.battlecfgid = _os_.unmarshal_int();
/*  163 */     this.result.unmarshal(_os_);
/*  164 */     this.stage = _os_.unmarshal_int();
/*  165 */     this.sessions.unmarshal(_os_);
/*  166 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  168 */       long _v_ = 0L;
/*  169 */       _v_ = _os_.unmarshal_long();
/*  170 */       this.allfightids.add(Long.valueOf(_v_));
/*      */     }
/*  172 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  178 */     _xdb_verify_unsafe_();
/*  179 */     int _size_ = 0;
/*  180 */     _size_ += CodedOutputStream.computeInt64Size(1, this.world);
/*  181 */     _size_ += CodedOutputStream.computeInt64Size(2, this.starttime);
/*  182 */     for (Map.Entry<Integer, xbean.CampInfo> _e_ : this.campinfos.entrySet())
/*      */     {
/*  184 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  185 */       _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*      */     }
/*  187 */     _size_ += CodedOutputStream.computeInt64Size(4, this.contextid);
/*  188 */     _size_ += CodedOutputStream.computeMessageSize(5, this.fightrecord);
/*  189 */     _size_ += CodedOutputStream.computeInt32Size(6, this.battlecfgid);
/*  190 */     _size_ += CodedOutputStream.computeMessageSize(7, this.result);
/*  191 */     _size_ += CodedOutputStream.computeInt32Size(8, this.stage);
/*  192 */     _size_ += CodedOutputStream.computeMessageSize(9, this.sessions);
/*  193 */     for (Long _v_ : this.allfightids)
/*      */     {
/*  195 */       _size_ += CodedOutputStream.computeInt64Size(10, _v_.longValue());
/*      */     }
/*  197 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  203 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  206 */       _output_.writeInt64(1, this.world);
/*  207 */       _output_.writeInt64(2, this.starttime);
/*  208 */       for (Map.Entry<Integer, xbean.CampInfo> _e_ : this.campinfos.entrySet())
/*      */       {
/*  210 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  211 */         _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*      */       }
/*  213 */       _output_.writeInt64(4, this.contextid);
/*  214 */       _output_.writeMessage(5, this.fightrecord);
/*  215 */       _output_.writeInt32(6, this.battlecfgid);
/*  216 */       _output_.writeMessage(7, this.result);
/*  217 */       _output_.writeInt32(8, this.stage);
/*  218 */       _output_.writeMessage(9, this.sessions);
/*  219 */       for (Long _v_ : this.allfightids)
/*      */       {
/*  221 */         _output_.writeInt64(10, _v_.longValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  226 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  228 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  234 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  237 */       boolean done = false;
/*  238 */       while (!done)
/*      */       {
/*  240 */         int tag = _input_.readTag();
/*  241 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  245 */           done = true;
/*  246 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  250 */           this.world = _input_.readInt64();
/*  251 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  255 */           this.starttime = _input_.readInt64();
/*  256 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  260 */           int _k_ = 0;
/*  261 */           _k_ = _input_.readInt32();
/*  262 */           int readTag = _input_.readTag();
/*  263 */           if (26 != readTag)
/*      */           {
/*  265 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  267 */           xbean.CampInfo _v_ = new CampInfo(0, this, "campinfos");
/*  268 */           _input_.readMessage(_v_);
/*  269 */           this.campinfos.put(Integer.valueOf(_k_), _v_);
/*  270 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  274 */           this.contextid = _input_.readInt64();
/*  275 */           break;
/*      */         
/*      */ 
/*      */         case 42: 
/*  279 */           _input_.readMessage(this.fightrecord);
/*  280 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  284 */           this.battlecfgid = _input_.readInt32();
/*  285 */           break;
/*      */         
/*      */ 
/*      */         case 58: 
/*  289 */           _input_.readMessage(this.result);
/*  290 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  294 */           this.stage = _input_.readInt32();
/*  295 */           break;
/*      */         
/*      */ 
/*      */         case 74: 
/*  299 */           _input_.readMessage(this.sessions);
/*  300 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  304 */           long _v_ = 0L;
/*  305 */           _v_ = _input_.readInt64();
/*  306 */           this.allfightids.add(Long.valueOf(_v_));
/*  307 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  311 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  313 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  322 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  326 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  328 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GlobalSingleBattleData copy()
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     return new GlobalSingleBattleData(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GlobalSingleBattleData toData()
/*      */   {
/*  341 */     _xdb_verify_unsafe_();
/*  342 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.GlobalSingleBattleData toBean()
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*  348 */     return new GlobalSingleBattleData(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GlobalSingleBattleData toDataIf()
/*      */   {
/*  354 */     _xdb_verify_unsafe_();
/*  355 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.GlobalSingleBattleData toBeanIf()
/*      */   {
/*  360 */     _xdb_verify_unsafe_();
/*  361 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  367 */     _xdb_verify_unsafe_();
/*  368 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getWorld()
/*      */   {
/*  375 */     _xdb_verify_unsafe_();
/*  376 */     return this.world;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStarttime()
/*      */   {
/*  383 */     _xdb_verify_unsafe_();
/*  384 */     return this.starttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.CampInfo> getCampinfos()
/*      */   {
/*  391 */     _xdb_verify_unsafe_();
/*  392 */     return Logs.logMap(new LogKey(this, "campinfos"), this.campinfos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.CampInfo> getCampinfosAsData()
/*      */   {
/*  399 */     _xdb_verify_unsafe_();
/*      */     
/*  401 */     GlobalSingleBattleData _o_ = this;
/*  402 */     Map<Integer, xbean.CampInfo> campinfos = new HashMap();
/*  403 */     for (Map.Entry<Integer, xbean.CampInfo> _e_ : _o_.campinfos.entrySet())
/*  404 */       campinfos.put(_e_.getKey(), new CampInfo.Data((xbean.CampInfo)_e_.getValue()));
/*  405 */     return campinfos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getContextid()
/*      */   {
/*  412 */     _xdb_verify_unsafe_();
/*  413 */     return this.contextid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.BattleFightRecord getFightrecord()
/*      */   {
/*  420 */     _xdb_verify_unsafe_();
/*  421 */     return this.fightrecord;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBattlecfgid()
/*      */   {
/*  428 */     _xdb_verify_unsafe_();
/*  429 */     return this.battlecfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.SingleBattleResult getResult()
/*      */   {
/*  436 */     _xdb_verify_unsafe_();
/*  437 */     return this.result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getStage()
/*      */   {
/*  444 */     _xdb_verify_unsafe_();
/*  445 */     return this.stage;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.SingleBattleSessions getSessions()
/*      */   {
/*  452 */     _xdb_verify_unsafe_();
/*  453 */     return this.sessions;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getAllfightids()
/*      */   {
/*  460 */     _xdb_verify_unsafe_();
/*  461 */     return Logs.logSet(new LogKey(this, "allfightids"), this.allfightids);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getAllfightidsAsData()
/*      */   {
/*  467 */     _xdb_verify_unsafe_();
/*      */     
/*  469 */     GlobalSingleBattleData _o_ = this;
/*  470 */     Set<Long> allfightids = new SetX();
/*  471 */     allfightids.addAll(_o_.allfightids);
/*  472 */     return allfightids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWorld(long _v_)
/*      */   {
/*  479 */     _xdb_verify_unsafe_();
/*  480 */     Logs.logIf(new LogKey(this, "world")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  484 */         new LogLong(this, GlobalSingleBattleData.this.world)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  488 */             GlobalSingleBattleData.this.world = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  492 */     });
/*  493 */     this.world = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStarttime(long _v_)
/*      */   {
/*  500 */     _xdb_verify_unsafe_();
/*  501 */     Logs.logIf(new LogKey(this, "starttime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  505 */         new LogLong(this, GlobalSingleBattleData.this.starttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  509 */             GlobalSingleBattleData.this.starttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  513 */     });
/*  514 */     this.starttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setContextid(long _v_)
/*      */   {
/*  521 */     _xdb_verify_unsafe_();
/*  522 */     Logs.logIf(new LogKey(this, "contextid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  526 */         new LogLong(this, GlobalSingleBattleData.this.contextid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  530 */             GlobalSingleBattleData.this.contextid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  534 */     });
/*  535 */     this.contextid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBattlecfgid(int _v_)
/*      */   {
/*  542 */     _xdb_verify_unsafe_();
/*  543 */     Logs.logIf(new LogKey(this, "battlecfgid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  547 */         new xdb.logs.LogInt(this, GlobalSingleBattleData.this.battlecfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  551 */             GlobalSingleBattleData.this.battlecfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  555 */     });
/*  556 */     this.battlecfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStage(int _v_)
/*      */   {
/*  563 */     _xdb_verify_unsafe_();
/*  564 */     Logs.logIf(new LogKey(this, "stage")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  568 */         new xdb.logs.LogInt(this, GlobalSingleBattleData.this.stage)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  572 */             GlobalSingleBattleData.this.stage = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  576 */     });
/*  577 */     this.stage = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  583 */     _xdb_verify_unsafe_();
/*  584 */     GlobalSingleBattleData _o_ = null;
/*  585 */     if ((_o1_ instanceof GlobalSingleBattleData)) { _o_ = (GlobalSingleBattleData)_o1_;
/*  586 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  587 */       return false;
/*  588 */     if (this.world != _o_.world) return false;
/*  589 */     if (this.starttime != _o_.starttime) return false;
/*  590 */     if (!this.campinfos.equals(_o_.campinfos)) return false;
/*  591 */     if (this.contextid != _o_.contextid) return false;
/*  592 */     if (!this.fightrecord.equals(_o_.fightrecord)) return false;
/*  593 */     if (this.battlecfgid != _o_.battlecfgid) return false;
/*  594 */     if (!this.result.equals(_o_.result)) return false;
/*  595 */     if (this.stage != _o_.stage) return false;
/*  596 */     if (!this.sessions.equals(_o_.sessions)) return false;
/*  597 */     if (!this.allfightids.equals(_o_.allfightids)) return false;
/*  598 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  604 */     _xdb_verify_unsafe_();
/*  605 */     int _h_ = 0;
/*  606 */     _h_ = (int)(_h_ + this.world);
/*  607 */     _h_ = (int)(_h_ + this.starttime);
/*  608 */     _h_ += this.campinfos.hashCode();
/*  609 */     _h_ = (int)(_h_ + this.contextid);
/*  610 */     _h_ += this.fightrecord.hashCode();
/*  611 */     _h_ += this.battlecfgid;
/*  612 */     _h_ += this.result.hashCode();
/*  613 */     _h_ += this.stage;
/*  614 */     _h_ += this.sessions.hashCode();
/*  615 */     _h_ += this.allfightids.hashCode();
/*  616 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  622 */     _xdb_verify_unsafe_();
/*  623 */     StringBuilder _sb_ = new StringBuilder();
/*  624 */     _sb_.append("(");
/*  625 */     _sb_.append(this.world);
/*  626 */     _sb_.append(",");
/*  627 */     _sb_.append(this.starttime);
/*  628 */     _sb_.append(",");
/*  629 */     _sb_.append(this.campinfos);
/*  630 */     _sb_.append(",");
/*  631 */     _sb_.append(this.contextid);
/*  632 */     _sb_.append(",");
/*  633 */     _sb_.append(this.fightrecord);
/*  634 */     _sb_.append(",");
/*  635 */     _sb_.append(this.battlecfgid);
/*  636 */     _sb_.append(",");
/*  637 */     _sb_.append(this.result);
/*  638 */     _sb_.append(",");
/*  639 */     _sb_.append(this.stage);
/*  640 */     _sb_.append(",");
/*  641 */     _sb_.append(this.sessions);
/*  642 */     _sb_.append(",");
/*  643 */     _sb_.append(this.allfightids);
/*  644 */     _sb_.append(")");
/*  645 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  651 */     ListenableBean lb = new ListenableBean();
/*  652 */     lb.add(new ListenableChanged().setVarName("world"));
/*  653 */     lb.add(new ListenableChanged().setVarName("starttime"));
/*  654 */     lb.add(new xdb.logs.ListenableMap().setVarName("campinfos"));
/*  655 */     lb.add(new ListenableChanged().setVarName("contextid"));
/*  656 */     lb.add(new ListenableChanged().setVarName("fightrecord"));
/*  657 */     lb.add(new ListenableChanged().setVarName("battlecfgid"));
/*  658 */     lb.add(new ListenableChanged().setVarName("result"));
/*  659 */     lb.add(new ListenableChanged().setVarName("stage"));
/*  660 */     lb.add(new ListenableChanged().setVarName("sessions"));
/*  661 */     lb.add(new xdb.logs.ListenableSet().setVarName("allfightids"));
/*  662 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.GlobalSingleBattleData {
/*      */     private Const() {}
/*      */     
/*      */     GlobalSingleBattleData nThis() {
/*  669 */       return GlobalSingleBattleData.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  675 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GlobalSingleBattleData copy()
/*      */     {
/*  681 */       return GlobalSingleBattleData.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GlobalSingleBattleData toData()
/*      */     {
/*  687 */       return GlobalSingleBattleData.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.GlobalSingleBattleData toBean()
/*      */     {
/*  692 */       return GlobalSingleBattleData.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GlobalSingleBattleData toDataIf()
/*      */     {
/*  698 */       return GlobalSingleBattleData.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.GlobalSingleBattleData toBeanIf()
/*      */     {
/*  703 */       return GlobalSingleBattleData.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWorld()
/*      */     {
/*  710 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  711 */       return GlobalSingleBattleData.this.world;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/*  718 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  719 */       return GlobalSingleBattleData.this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.CampInfo> getCampinfos()
/*      */     {
/*  726 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  727 */       return xdb.Consts.constMap(GlobalSingleBattleData.this.campinfos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.CampInfo> getCampinfosAsData()
/*      */     {
/*  734 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*      */       
/*  736 */       GlobalSingleBattleData _o_ = GlobalSingleBattleData.this;
/*  737 */       Map<Integer, xbean.CampInfo> campinfos = new HashMap();
/*  738 */       for (Map.Entry<Integer, xbean.CampInfo> _e_ : _o_.campinfos.entrySet())
/*  739 */         campinfos.put(_e_.getKey(), new CampInfo.Data((xbean.CampInfo)_e_.getValue()));
/*  740 */       return campinfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getContextid()
/*      */     {
/*  747 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  748 */       return GlobalSingleBattleData.this.contextid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.BattleFightRecord getFightrecord()
/*      */     {
/*  755 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  756 */       return (xbean.BattleFightRecord)xdb.Consts.toConst(GlobalSingleBattleData.this.fightrecord);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBattlecfgid()
/*      */     {
/*  763 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  764 */       return GlobalSingleBattleData.this.battlecfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.SingleBattleResult getResult()
/*      */     {
/*  771 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  772 */       return (xbean.SingleBattleResult)xdb.Consts.toConst(GlobalSingleBattleData.this.result);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStage()
/*      */     {
/*  779 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  780 */       return GlobalSingleBattleData.this.stage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.SingleBattleSessions getSessions()
/*      */     {
/*  787 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  788 */       return (xbean.SingleBattleSessions)xdb.Consts.toConst(GlobalSingleBattleData.this.sessions);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getAllfightids()
/*      */     {
/*  795 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  796 */       return xdb.Consts.constSet(GlobalSingleBattleData.this.allfightids);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getAllfightidsAsData()
/*      */     {
/*  802 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*      */       
/*  804 */       GlobalSingleBattleData _o_ = GlobalSingleBattleData.this;
/*  805 */       Set<Long> allfightids = new SetX();
/*  806 */       allfightids.addAll(_o_.allfightids);
/*  807 */       return allfightids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorld(long _v_)
/*      */     {
/*  814 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  815 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/*  822 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  823 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setContextid(long _v_)
/*      */     {
/*  830 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  831 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBattlecfgid(int _v_)
/*      */     {
/*  838 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  839 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStage(int _v_)
/*      */     {
/*  846 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  847 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  853 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  854 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  860 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  861 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  867 */       return GlobalSingleBattleData.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  873 */       return GlobalSingleBattleData.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  879 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  880 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  886 */       return GlobalSingleBattleData.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  892 */       return GlobalSingleBattleData.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  898 */       GlobalSingleBattleData.this._xdb_verify_unsafe_();
/*  899 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  905 */       return GlobalSingleBattleData.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  911 */       return GlobalSingleBattleData.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  917 */       return GlobalSingleBattleData.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  923 */       return GlobalSingleBattleData.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  929 */       return GlobalSingleBattleData.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  935 */       return GlobalSingleBattleData.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  941 */       return GlobalSingleBattleData.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.GlobalSingleBattleData
/*      */   {
/*      */     private long world;
/*      */     
/*      */     private long starttime;
/*      */     
/*      */     private HashMap<Integer, xbean.CampInfo> campinfos;
/*      */     
/*      */     private long contextid;
/*      */     
/*      */     private xbean.BattleFightRecord fightrecord;
/*      */     
/*      */     private int battlecfgid;
/*      */     
/*      */     private xbean.SingleBattleResult result;
/*      */     
/*      */     private int stage;
/*      */     
/*      */     private xbean.SingleBattleSessions sessions;
/*      */     
/*      */     private HashSet<Long> allfightids;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  971 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  976 */       this.world = -1L;
/*  977 */       this.campinfos = new HashMap();
/*  978 */       this.fightrecord = new BattleFightRecord.Data();
/*  979 */       this.result = new SingleBattleResult.Data();
/*  980 */       this.sessions = new SingleBattleSessions.Data();
/*  981 */       this.allfightids = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.GlobalSingleBattleData _o1_)
/*      */     {
/*  986 */       if ((_o1_ instanceof GlobalSingleBattleData)) { assign((GlobalSingleBattleData)_o1_);
/*  987 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  988 */       } else if ((_o1_ instanceof GlobalSingleBattleData.Const)) assign(((GlobalSingleBattleData.Const)_o1_).nThis()); else {
/*  989 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(GlobalSingleBattleData _o_) {
/*  994 */       this.world = _o_.world;
/*  995 */       this.starttime = _o_.starttime;
/*  996 */       this.campinfos = new HashMap();
/*  997 */       for (Map.Entry<Integer, xbean.CampInfo> _e_ : _o_.campinfos.entrySet())
/*  998 */         this.campinfos.put(_e_.getKey(), new CampInfo.Data((xbean.CampInfo)_e_.getValue()));
/*  999 */       this.contextid = _o_.contextid;
/* 1000 */       this.fightrecord = new BattleFightRecord.Data(_o_.fightrecord);
/* 1001 */       this.battlecfgid = _o_.battlecfgid;
/* 1002 */       this.result = new SingleBattleResult.Data(_o_.result);
/* 1003 */       this.stage = _o_.stage;
/* 1004 */       this.sessions = new SingleBattleSessions.Data(_o_.sessions);
/* 1005 */       this.allfightids = new HashSet();
/* 1006 */       this.allfightids.addAll(_o_.allfightids);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1011 */       this.world = _o_.world;
/* 1012 */       this.starttime = _o_.starttime;
/* 1013 */       this.campinfos = new HashMap();
/* 1014 */       for (Map.Entry<Integer, xbean.CampInfo> _e_ : _o_.campinfos.entrySet())
/* 1015 */         this.campinfos.put(_e_.getKey(), new CampInfo.Data((xbean.CampInfo)_e_.getValue()));
/* 1016 */       this.contextid = _o_.contextid;
/* 1017 */       this.fightrecord = new BattleFightRecord.Data(_o_.fightrecord);
/* 1018 */       this.battlecfgid = _o_.battlecfgid;
/* 1019 */       this.result = new SingleBattleResult.Data(_o_.result);
/* 1020 */       this.stage = _o_.stage;
/* 1021 */       this.sessions = new SingleBattleSessions.Data(_o_.sessions);
/* 1022 */       this.allfightids = new HashSet();
/* 1023 */       this.allfightids.addAll(_o_.allfightids);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1029 */       _os_.marshal(this.world);
/* 1030 */       _os_.marshal(this.starttime);
/* 1031 */       _os_.compact_uint32(this.campinfos.size());
/* 1032 */       for (Map.Entry<Integer, xbean.CampInfo> _e_ : this.campinfos.entrySet())
/*      */       {
/* 1034 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1035 */         ((xbean.CampInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1037 */       _os_.marshal(this.contextid);
/* 1038 */       this.fightrecord.marshal(_os_);
/* 1039 */       _os_.marshal(this.battlecfgid);
/* 1040 */       this.result.marshal(_os_);
/* 1041 */       _os_.marshal(this.stage);
/* 1042 */       this.sessions.marshal(_os_);
/* 1043 */       _os_.compact_uint32(this.allfightids.size());
/* 1044 */       for (Long _v_ : this.allfightids)
/*      */       {
/* 1046 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1048 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1054 */       this.world = _os_.unmarshal_long();
/* 1055 */       this.starttime = _os_.unmarshal_long();
/*      */       
/* 1057 */       int size = _os_.uncompact_uint32();
/* 1058 */       if (size >= 12)
/*      */       {
/* 1060 */         this.campinfos = new HashMap(size * 2);
/*      */       }
/* 1062 */       for (; size > 0; size--)
/*      */       {
/* 1064 */         int _k_ = 0;
/* 1065 */         _k_ = _os_.unmarshal_int();
/* 1066 */         xbean.CampInfo _v_ = xbean.Pod.newCampInfoData();
/* 1067 */         _v_.unmarshal(_os_);
/* 1068 */         this.campinfos.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1071 */       this.contextid = _os_.unmarshal_long();
/* 1072 */       this.fightrecord.unmarshal(_os_);
/* 1073 */       this.battlecfgid = _os_.unmarshal_int();
/* 1074 */       this.result.unmarshal(_os_);
/* 1075 */       this.stage = _os_.unmarshal_int();
/* 1076 */       this.sessions.unmarshal(_os_);
/* 1077 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1079 */         long _v_ = 0L;
/* 1080 */         _v_ = _os_.unmarshal_long();
/* 1081 */         this.allfightids.add(Long.valueOf(_v_));
/*      */       }
/* 1083 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1089 */       int _size_ = 0;
/* 1090 */       _size_ += CodedOutputStream.computeInt64Size(1, this.world);
/* 1091 */       _size_ += CodedOutputStream.computeInt64Size(2, this.starttime);
/* 1092 */       for (Map.Entry<Integer, xbean.CampInfo> _e_ : this.campinfos.entrySet())
/*      */       {
/* 1094 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 1095 */         _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1097 */       _size_ += CodedOutputStream.computeInt64Size(4, this.contextid);
/* 1098 */       _size_ += CodedOutputStream.computeMessageSize(5, this.fightrecord);
/* 1099 */       _size_ += CodedOutputStream.computeInt32Size(6, this.battlecfgid);
/* 1100 */       _size_ += CodedOutputStream.computeMessageSize(7, this.result);
/* 1101 */       _size_ += CodedOutputStream.computeInt32Size(8, this.stage);
/* 1102 */       _size_ += CodedOutputStream.computeMessageSize(9, this.sessions);
/* 1103 */       for (Long _v_ : this.allfightids)
/*      */       {
/* 1105 */         _size_ += CodedOutputStream.computeInt64Size(10, _v_.longValue());
/*      */       }
/* 1107 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1115 */         _output_.writeInt64(1, this.world);
/* 1116 */         _output_.writeInt64(2, this.starttime);
/* 1117 */         for (Map.Entry<Integer, xbean.CampInfo> _e_ : this.campinfos.entrySet())
/*      */         {
/* 1119 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 1120 */           _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1122 */         _output_.writeInt64(4, this.contextid);
/* 1123 */         _output_.writeMessage(5, this.fightrecord);
/* 1124 */         _output_.writeInt32(6, this.battlecfgid);
/* 1125 */         _output_.writeMessage(7, this.result);
/* 1126 */         _output_.writeInt32(8, this.stage);
/* 1127 */         _output_.writeMessage(9, this.sessions);
/* 1128 */         for (Long _v_ : this.allfightids)
/*      */         {
/* 1130 */           _output_.writeInt64(10, _v_.longValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1135 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1137 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1145 */         boolean done = false;
/* 1146 */         while (!done)
/*      */         {
/* 1148 */           int tag = _input_.readTag();
/* 1149 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1153 */             done = true;
/* 1154 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1158 */             this.world = _input_.readInt64();
/* 1159 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1163 */             this.starttime = _input_.readInt64();
/* 1164 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1168 */             int _k_ = 0;
/* 1169 */             _k_ = _input_.readInt32();
/* 1170 */             int readTag = _input_.readTag();
/* 1171 */             if (26 != readTag)
/*      */             {
/* 1173 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1175 */             xbean.CampInfo _v_ = xbean.Pod.newCampInfoData();
/* 1176 */             _input_.readMessage(_v_);
/* 1177 */             this.campinfos.put(Integer.valueOf(_k_), _v_);
/* 1178 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1182 */             this.contextid = _input_.readInt64();
/* 1183 */             break;
/*      */           
/*      */ 
/*      */           case 42: 
/* 1187 */             _input_.readMessage(this.fightrecord);
/* 1188 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1192 */             this.battlecfgid = _input_.readInt32();
/* 1193 */             break;
/*      */           
/*      */ 
/*      */           case 58: 
/* 1197 */             _input_.readMessage(this.result);
/* 1198 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1202 */             this.stage = _input_.readInt32();
/* 1203 */             break;
/*      */           
/*      */ 
/*      */           case 74: 
/* 1207 */             _input_.readMessage(this.sessions);
/* 1208 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1212 */             long _v_ = 0L;
/* 1213 */             _v_ = _input_.readInt64();
/* 1214 */             this.allfightids.add(Long.valueOf(_v_));
/* 1215 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1219 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1221 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1230 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1234 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1236 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GlobalSingleBattleData copy()
/*      */     {
/* 1242 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GlobalSingleBattleData toData()
/*      */     {
/* 1248 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.GlobalSingleBattleData toBean()
/*      */     {
/* 1253 */       return new GlobalSingleBattleData(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GlobalSingleBattleData toDataIf()
/*      */     {
/* 1259 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.GlobalSingleBattleData toBeanIf()
/*      */     {
/* 1264 */       return new GlobalSingleBattleData(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1270 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1274 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1278 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1282 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1286 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1290 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1294 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWorld()
/*      */     {
/* 1301 */       return this.world;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/* 1308 */       return this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.CampInfo> getCampinfos()
/*      */     {
/* 1315 */       return this.campinfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.CampInfo> getCampinfosAsData()
/*      */     {
/* 1322 */       return this.campinfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getContextid()
/*      */     {
/* 1329 */       return this.contextid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.BattleFightRecord getFightrecord()
/*      */     {
/* 1336 */       return this.fightrecord;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBattlecfgid()
/*      */     {
/* 1343 */       return this.battlecfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.SingleBattleResult getResult()
/*      */     {
/* 1350 */       return this.result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStage()
/*      */     {
/* 1357 */       return this.stage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.SingleBattleSessions getSessions()
/*      */     {
/* 1364 */       return this.sessions;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getAllfightids()
/*      */     {
/* 1371 */       return this.allfightids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getAllfightidsAsData()
/*      */     {
/* 1378 */       return this.allfightids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorld(long _v_)
/*      */     {
/* 1385 */       this.world = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/* 1392 */       this.starttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setContextid(long _v_)
/*      */     {
/* 1399 */       this.contextid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBattlecfgid(int _v_)
/*      */     {
/* 1406 */       this.battlecfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStage(int _v_)
/*      */     {
/* 1413 */       this.stage = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1419 */       if (!(_o1_ instanceof Data)) return false;
/* 1420 */       Data _o_ = (Data)_o1_;
/* 1421 */       if (this.world != _o_.world) return false;
/* 1422 */       if (this.starttime != _o_.starttime) return false;
/* 1423 */       if (!this.campinfos.equals(_o_.campinfos)) return false;
/* 1424 */       if (this.contextid != _o_.contextid) return false;
/* 1425 */       if (!this.fightrecord.equals(_o_.fightrecord)) return false;
/* 1426 */       if (this.battlecfgid != _o_.battlecfgid) return false;
/* 1427 */       if (!this.result.equals(_o_.result)) return false;
/* 1428 */       if (this.stage != _o_.stage) return false;
/* 1429 */       if (!this.sessions.equals(_o_.sessions)) return false;
/* 1430 */       if (!this.allfightids.equals(_o_.allfightids)) return false;
/* 1431 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1437 */       int _h_ = 0;
/* 1438 */       _h_ = (int)(_h_ + this.world);
/* 1439 */       _h_ = (int)(_h_ + this.starttime);
/* 1440 */       _h_ += this.campinfos.hashCode();
/* 1441 */       _h_ = (int)(_h_ + this.contextid);
/* 1442 */       _h_ += this.fightrecord.hashCode();
/* 1443 */       _h_ += this.battlecfgid;
/* 1444 */       _h_ += this.result.hashCode();
/* 1445 */       _h_ += this.stage;
/* 1446 */       _h_ += this.sessions.hashCode();
/* 1447 */       _h_ += this.allfightids.hashCode();
/* 1448 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1454 */       StringBuilder _sb_ = new StringBuilder();
/* 1455 */       _sb_.append("(");
/* 1456 */       _sb_.append(this.world);
/* 1457 */       _sb_.append(",");
/* 1458 */       _sb_.append(this.starttime);
/* 1459 */       _sb_.append(",");
/* 1460 */       _sb_.append(this.campinfos);
/* 1461 */       _sb_.append(",");
/* 1462 */       _sb_.append(this.contextid);
/* 1463 */       _sb_.append(",");
/* 1464 */       _sb_.append(this.fightrecord);
/* 1465 */       _sb_.append(",");
/* 1466 */       _sb_.append(this.battlecfgid);
/* 1467 */       _sb_.append(",");
/* 1468 */       _sb_.append(this.result);
/* 1469 */       _sb_.append(",");
/* 1470 */       _sb_.append(this.stage);
/* 1471 */       _sb_.append(",");
/* 1472 */       _sb_.append(this.sessions);
/* 1473 */       _sb_.append(",");
/* 1474 */       _sb_.append(this.allfightids);
/* 1475 */       _sb_.append(")");
/* 1476 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GlobalSingleBattleData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */