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
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class Role2TreasureHuntWorldInfo extends XBean implements xbean.Role2TreasureHuntWorldInfo
/*      */ {
/*      */   private long world_id;
/*      */   private int chapter_cfg_id;
/*      */   private int process;
/*      */   private long session_id;
/*      */   private HashMap<Integer, Integer> trigger_effect_map;
/*      */   private SetX<Integer> trigger_buff_set;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.world_id = 0L;
/*   29 */     this.chapter_cfg_id = 0;
/*   30 */     this.process = 0;
/*   31 */     this.session_id = 0L;
/*   32 */     this.trigger_effect_map.clear();
/*   33 */     this.trigger_buff_set.clear();
/*      */   }
/*      */   
/*      */   Role2TreasureHuntWorldInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.trigger_effect_map = new HashMap();
/*   40 */     this.trigger_buff_set = new SetX();
/*      */   }
/*      */   
/*      */   public Role2TreasureHuntWorldInfo()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Role2TreasureHuntWorldInfo(Role2TreasureHuntWorldInfo _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Role2TreasureHuntWorldInfo(xbean.Role2TreasureHuntWorldInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof Role2TreasureHuntWorldInfo)) { assign((Role2TreasureHuntWorldInfo)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Role2TreasureHuntWorldInfo _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.world_id = _o_.world_id;
/*   66 */     this.chapter_cfg_id = _o_.chapter_cfg_id;
/*   67 */     this.process = _o_.process;
/*   68 */     this.session_id = _o_.session_id;
/*   69 */     this.trigger_effect_map = new HashMap();
/*   70 */     for (Map.Entry<Integer, Integer> _e_ : _o_.trigger_effect_map.entrySet())
/*   71 */       this.trigger_effect_map.put(_e_.getKey(), _e_.getValue());
/*   72 */     this.trigger_buff_set = new SetX();
/*   73 */     this.trigger_buff_set.addAll(_o_.trigger_buff_set);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   78 */     this.world_id = _o_.world_id;
/*   79 */     this.chapter_cfg_id = _o_.chapter_cfg_id;
/*   80 */     this.process = _o_.process;
/*   81 */     this.session_id = _o_.session_id;
/*   82 */     this.trigger_effect_map = new HashMap();
/*   83 */     for (Map.Entry<Integer, Integer> _e_ : _o_.trigger_effect_map.entrySet())
/*   84 */       this.trigger_effect_map.put(_e_.getKey(), _e_.getValue());
/*   85 */     this.trigger_buff_set = new SetX();
/*   86 */     this.trigger_buff_set.addAll(_o_.trigger_buff_set);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   92 */     _xdb_verify_unsafe_();
/*   93 */     _os_.marshal(this.world_id);
/*   94 */     _os_.marshal(this.chapter_cfg_id);
/*   95 */     _os_.marshal(this.process);
/*   96 */     _os_.marshal(this.session_id);
/*   97 */     _os_.compact_uint32(this.trigger_effect_map.size());
/*   98 */     for (Map.Entry<Integer, Integer> _e_ : this.trigger_effect_map.entrySet())
/*      */     {
/*  100 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  101 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  103 */     _os_.compact_uint32(this.trigger_buff_set.size());
/*  104 */     for (Integer _v_ : this.trigger_buff_set)
/*      */     {
/*  106 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  108 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  114 */     _xdb_verify_unsafe_();
/*  115 */     this.world_id = _os_.unmarshal_long();
/*  116 */     this.chapter_cfg_id = _os_.unmarshal_int();
/*  117 */     this.process = _os_.unmarshal_int();
/*  118 */     this.session_id = _os_.unmarshal_long();
/*      */     
/*  120 */     int size = _os_.uncompact_uint32();
/*  121 */     if (size >= 12)
/*      */     {
/*  123 */       this.trigger_effect_map = new HashMap(size * 2);
/*      */     }
/*  125 */     for (; size > 0; size--)
/*      */     {
/*  127 */       int _k_ = 0;
/*  128 */       _k_ = _os_.unmarshal_int();
/*  129 */       int _v_ = 0;
/*  130 */       _v_ = _os_.unmarshal_int();
/*  131 */       this.trigger_effect_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  134 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  136 */       int _v_ = 0;
/*  137 */       _v_ = _os_.unmarshal_int();
/*  138 */       this.trigger_buff_set.add(Integer.valueOf(_v_));
/*      */     }
/*  140 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  146 */     _xdb_verify_unsafe_();
/*  147 */     int _size_ = 0;
/*  148 */     _size_ += CodedOutputStream.computeInt64Size(1, this.world_id);
/*  149 */     _size_ += CodedOutputStream.computeInt32Size(2, this.chapter_cfg_id);
/*  150 */     _size_ += CodedOutputStream.computeInt32Size(3, this.process);
/*  151 */     _size_ += CodedOutputStream.computeInt64Size(4, this.session_id);
/*  152 */     for (Map.Entry<Integer, Integer> _e_ : this.trigger_effect_map.entrySet())
/*      */     {
/*  154 */       _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/*  155 */       _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  157 */     for (Integer _v_ : this.trigger_buff_set)
/*      */     {
/*  159 */       _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */     }
/*  161 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  167 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  170 */       _output_.writeInt64(1, this.world_id);
/*  171 */       _output_.writeInt32(2, this.chapter_cfg_id);
/*  172 */       _output_.writeInt32(3, this.process);
/*  173 */       _output_.writeInt64(4, this.session_id);
/*  174 */       for (Map.Entry<Integer, Integer> _e_ : this.trigger_effect_map.entrySet())
/*      */       {
/*  176 */         _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/*  177 */         _output_.writeInt32(5, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  179 */       for (Integer _v_ : this.trigger_buff_set)
/*      */       {
/*  181 */         _output_.writeInt32(6, _v_.intValue());
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
/*  210 */           this.world_id = _input_.readInt64();
/*  211 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  215 */           this.chapter_cfg_id = _input_.readInt32();
/*  216 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  220 */           this.process = _input_.readInt32();
/*  221 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  225 */           this.session_id = _input_.readInt64();
/*  226 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  230 */           int _k_ = 0;
/*  231 */           _k_ = _input_.readInt32();
/*  232 */           int readTag = _input_.readTag();
/*  233 */           if (40 != readTag)
/*      */           {
/*  235 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  237 */           int _v_ = 0;
/*  238 */           _v_ = _input_.readInt32();
/*  239 */           this.trigger_effect_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  240 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  244 */           int _v_ = 0;
/*  245 */           _v_ = _input_.readInt32();
/*  246 */           this.trigger_buff_set.add(Integer.valueOf(_v_));
/*  247 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  251 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  253 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  262 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  266 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  268 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2TreasureHuntWorldInfo copy()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return new Role2TreasureHuntWorldInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2TreasureHuntWorldInfo toData()
/*      */   {
/*  281 */     _xdb_verify_unsafe_();
/*  282 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2TreasureHuntWorldInfo toBean()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return new Role2TreasureHuntWorldInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2TreasureHuntWorldInfo toDataIf()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2TreasureHuntWorldInfo toBeanIf()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getWorld_id()
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*  316 */     return this.world_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getChapter_cfg_id()
/*      */   {
/*  323 */     _xdb_verify_unsafe_();
/*  324 */     return this.chapter_cfg_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getProcess()
/*      */   {
/*  331 */     _xdb_verify_unsafe_();
/*  332 */     return this.process;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSession_id()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     return this.session_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getTrigger_effect_map()
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*  348 */     return xdb.Logs.logMap(new LogKey(this, "trigger_effect_map"), this.trigger_effect_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getTrigger_effect_mapAsData()
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*      */     
/*  357 */     Role2TreasureHuntWorldInfo _o_ = this;
/*  358 */     Map<Integer, Integer> trigger_effect_map = new HashMap();
/*  359 */     for (Map.Entry<Integer, Integer> _e_ : _o_.trigger_effect_map.entrySet())
/*  360 */       trigger_effect_map.put(_e_.getKey(), _e_.getValue());
/*  361 */     return trigger_effect_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getTrigger_buff_set()
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*  369 */     return xdb.Logs.logSet(new LogKey(this, "trigger_buff_set"), this.trigger_buff_set);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getTrigger_buff_setAsData()
/*      */   {
/*  375 */     _xdb_verify_unsafe_();
/*      */     
/*  377 */     Role2TreasureHuntWorldInfo _o_ = this;
/*  378 */     Set<Integer> trigger_buff_set = new SetX();
/*  379 */     trigger_buff_set.addAll(_o_.trigger_buff_set);
/*  380 */     return trigger_buff_set;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWorld_id(long _v_)
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     xdb.Logs.logIf(new LogKey(this, "world_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  392 */         new xdb.logs.LogLong(this, Role2TreasureHuntWorldInfo.this.world_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  396 */             Role2TreasureHuntWorldInfo.this.world_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  400 */     });
/*  401 */     this.world_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChapter_cfg_id(int _v_)
/*      */   {
/*  408 */     _xdb_verify_unsafe_();
/*  409 */     xdb.Logs.logIf(new LogKey(this, "chapter_cfg_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  413 */         new xdb.logs.LogInt(this, Role2TreasureHuntWorldInfo.this.chapter_cfg_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  417 */             Role2TreasureHuntWorldInfo.this.chapter_cfg_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  421 */     });
/*  422 */     this.chapter_cfg_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setProcess(int _v_)
/*      */   {
/*  429 */     _xdb_verify_unsafe_();
/*  430 */     xdb.Logs.logIf(new LogKey(this, "process")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  434 */         new xdb.logs.LogInt(this, Role2TreasureHuntWorldInfo.this.process)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  438 */             Role2TreasureHuntWorldInfo.this.process = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  442 */     });
/*  443 */     this.process = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSession_id(long _v_)
/*      */   {
/*  450 */     _xdb_verify_unsafe_();
/*  451 */     xdb.Logs.logIf(new LogKey(this, "session_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  455 */         new xdb.logs.LogLong(this, Role2TreasureHuntWorldInfo.this.session_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  459 */             Role2TreasureHuntWorldInfo.this.session_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  463 */     });
/*  464 */     this.session_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  470 */     _xdb_verify_unsafe_();
/*  471 */     Role2TreasureHuntWorldInfo _o_ = null;
/*  472 */     if ((_o1_ instanceof Role2TreasureHuntWorldInfo)) { _o_ = (Role2TreasureHuntWorldInfo)_o1_;
/*  473 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  474 */       return false;
/*  475 */     if (this.world_id != _o_.world_id) return false;
/*  476 */     if (this.chapter_cfg_id != _o_.chapter_cfg_id) return false;
/*  477 */     if (this.process != _o_.process) return false;
/*  478 */     if (this.session_id != _o_.session_id) return false;
/*  479 */     if (!this.trigger_effect_map.equals(_o_.trigger_effect_map)) return false;
/*  480 */     if (!this.trigger_buff_set.equals(_o_.trigger_buff_set)) return false;
/*  481 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  487 */     _xdb_verify_unsafe_();
/*  488 */     int _h_ = 0;
/*  489 */     _h_ = (int)(_h_ + this.world_id);
/*  490 */     _h_ += this.chapter_cfg_id;
/*  491 */     _h_ += this.process;
/*  492 */     _h_ = (int)(_h_ + this.session_id);
/*  493 */     _h_ += this.trigger_effect_map.hashCode();
/*  494 */     _h_ += this.trigger_buff_set.hashCode();
/*  495 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  501 */     _xdb_verify_unsafe_();
/*  502 */     StringBuilder _sb_ = new StringBuilder();
/*  503 */     _sb_.append("(");
/*  504 */     _sb_.append(this.world_id);
/*  505 */     _sb_.append(",");
/*  506 */     _sb_.append(this.chapter_cfg_id);
/*  507 */     _sb_.append(",");
/*  508 */     _sb_.append(this.process);
/*  509 */     _sb_.append(",");
/*  510 */     _sb_.append(this.session_id);
/*  511 */     _sb_.append(",");
/*  512 */     _sb_.append(this.trigger_effect_map);
/*  513 */     _sb_.append(",");
/*  514 */     _sb_.append(this.trigger_buff_set);
/*  515 */     _sb_.append(")");
/*  516 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  522 */     ListenableBean lb = new ListenableBean();
/*  523 */     lb.add(new xdb.logs.ListenableChanged().setVarName("world_id"));
/*  524 */     lb.add(new xdb.logs.ListenableChanged().setVarName("chapter_cfg_id"));
/*  525 */     lb.add(new xdb.logs.ListenableChanged().setVarName("process"));
/*  526 */     lb.add(new xdb.logs.ListenableChanged().setVarName("session_id"));
/*  527 */     lb.add(new xdb.logs.ListenableMap().setVarName("trigger_effect_map"));
/*  528 */     lb.add(new xdb.logs.ListenableSet().setVarName("trigger_buff_set"));
/*  529 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Role2TreasureHuntWorldInfo {
/*      */     private Const() {}
/*      */     
/*      */     Role2TreasureHuntWorldInfo nThis() {
/*  536 */       return Role2TreasureHuntWorldInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  542 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2TreasureHuntWorldInfo copy()
/*      */     {
/*  548 */       return Role2TreasureHuntWorldInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2TreasureHuntWorldInfo toData()
/*      */     {
/*  554 */       return Role2TreasureHuntWorldInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Role2TreasureHuntWorldInfo toBean()
/*      */     {
/*  559 */       return Role2TreasureHuntWorldInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2TreasureHuntWorldInfo toDataIf()
/*      */     {
/*  565 */       return Role2TreasureHuntWorldInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Role2TreasureHuntWorldInfo toBeanIf()
/*      */     {
/*  570 */       return Role2TreasureHuntWorldInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWorld_id()
/*      */     {
/*  577 */       Role2TreasureHuntWorldInfo.this._xdb_verify_unsafe_();
/*  578 */       return Role2TreasureHuntWorldInfo.this.world_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChapter_cfg_id()
/*      */     {
/*  585 */       Role2TreasureHuntWorldInfo.this._xdb_verify_unsafe_();
/*  586 */       return Role2TreasureHuntWorldInfo.this.chapter_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getProcess()
/*      */     {
/*  593 */       Role2TreasureHuntWorldInfo.this._xdb_verify_unsafe_();
/*  594 */       return Role2TreasureHuntWorldInfo.this.process;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSession_id()
/*      */     {
/*  601 */       Role2TreasureHuntWorldInfo.this._xdb_verify_unsafe_();
/*  602 */       return Role2TreasureHuntWorldInfo.this.session_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getTrigger_effect_map()
/*      */     {
/*  609 */       Role2TreasureHuntWorldInfo.this._xdb_verify_unsafe_();
/*  610 */       return xdb.Consts.constMap(Role2TreasureHuntWorldInfo.this.trigger_effect_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getTrigger_effect_mapAsData()
/*      */     {
/*  617 */       Role2TreasureHuntWorldInfo.this._xdb_verify_unsafe_();
/*      */       
/*  619 */       Role2TreasureHuntWorldInfo _o_ = Role2TreasureHuntWorldInfo.this;
/*  620 */       Map<Integer, Integer> trigger_effect_map = new HashMap();
/*  621 */       for (Map.Entry<Integer, Integer> _e_ : _o_.trigger_effect_map.entrySet())
/*  622 */         trigger_effect_map.put(_e_.getKey(), _e_.getValue());
/*  623 */       return trigger_effect_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getTrigger_buff_set()
/*      */     {
/*  630 */       Role2TreasureHuntWorldInfo.this._xdb_verify_unsafe_();
/*  631 */       return xdb.Consts.constSet(Role2TreasureHuntWorldInfo.this.trigger_buff_set);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getTrigger_buff_setAsData()
/*      */     {
/*  637 */       Role2TreasureHuntWorldInfo.this._xdb_verify_unsafe_();
/*      */       
/*  639 */       Role2TreasureHuntWorldInfo _o_ = Role2TreasureHuntWorldInfo.this;
/*  640 */       Set<Integer> trigger_buff_set = new SetX();
/*  641 */       trigger_buff_set.addAll(_o_.trigger_buff_set);
/*  642 */       return trigger_buff_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorld_id(long _v_)
/*      */     {
/*  649 */       Role2TreasureHuntWorldInfo.this._xdb_verify_unsafe_();
/*  650 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChapter_cfg_id(int _v_)
/*      */     {
/*  657 */       Role2TreasureHuntWorldInfo.this._xdb_verify_unsafe_();
/*  658 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setProcess(int _v_)
/*      */     {
/*  665 */       Role2TreasureHuntWorldInfo.this._xdb_verify_unsafe_();
/*  666 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSession_id(long _v_)
/*      */     {
/*  673 */       Role2TreasureHuntWorldInfo.this._xdb_verify_unsafe_();
/*  674 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  680 */       Role2TreasureHuntWorldInfo.this._xdb_verify_unsafe_();
/*  681 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  687 */       Role2TreasureHuntWorldInfo.this._xdb_verify_unsafe_();
/*  688 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  694 */       return Role2TreasureHuntWorldInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  700 */       return Role2TreasureHuntWorldInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  706 */       Role2TreasureHuntWorldInfo.this._xdb_verify_unsafe_();
/*  707 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  713 */       return Role2TreasureHuntWorldInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  719 */       return Role2TreasureHuntWorldInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  725 */       Role2TreasureHuntWorldInfo.this._xdb_verify_unsafe_();
/*  726 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  732 */       return Role2TreasureHuntWorldInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  738 */       return Role2TreasureHuntWorldInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  744 */       return Role2TreasureHuntWorldInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  750 */       return Role2TreasureHuntWorldInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  756 */       return Role2TreasureHuntWorldInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  762 */       return Role2TreasureHuntWorldInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  768 */       return Role2TreasureHuntWorldInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Role2TreasureHuntWorldInfo
/*      */   {
/*      */     private long world_id;
/*      */     
/*      */     private int chapter_cfg_id;
/*      */     
/*      */     private int process;
/*      */     
/*      */     private long session_id;
/*      */     
/*      */     private HashMap<Integer, Integer> trigger_effect_map;
/*      */     
/*      */     private HashSet<Integer> trigger_buff_set;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  790 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  795 */       this.trigger_effect_map = new HashMap();
/*  796 */       this.trigger_buff_set = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.Role2TreasureHuntWorldInfo _o1_)
/*      */     {
/*  801 */       if ((_o1_ instanceof Role2TreasureHuntWorldInfo)) { assign((Role2TreasureHuntWorldInfo)_o1_);
/*  802 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  803 */       } else if ((_o1_ instanceof Role2TreasureHuntWorldInfo.Const)) assign(((Role2TreasureHuntWorldInfo.Const)_o1_).nThis()); else {
/*  804 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Role2TreasureHuntWorldInfo _o_) {
/*  809 */       this.world_id = _o_.world_id;
/*  810 */       this.chapter_cfg_id = _o_.chapter_cfg_id;
/*  811 */       this.process = _o_.process;
/*  812 */       this.session_id = _o_.session_id;
/*  813 */       this.trigger_effect_map = new HashMap();
/*  814 */       for (Map.Entry<Integer, Integer> _e_ : _o_.trigger_effect_map.entrySet())
/*  815 */         this.trigger_effect_map.put(_e_.getKey(), _e_.getValue());
/*  816 */       this.trigger_buff_set = new HashSet();
/*  817 */       this.trigger_buff_set.addAll(_o_.trigger_buff_set);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  822 */       this.world_id = _o_.world_id;
/*  823 */       this.chapter_cfg_id = _o_.chapter_cfg_id;
/*  824 */       this.process = _o_.process;
/*  825 */       this.session_id = _o_.session_id;
/*  826 */       this.trigger_effect_map = new HashMap();
/*  827 */       for (Map.Entry<Integer, Integer> _e_ : _o_.trigger_effect_map.entrySet())
/*  828 */         this.trigger_effect_map.put(_e_.getKey(), _e_.getValue());
/*  829 */       this.trigger_buff_set = new HashSet();
/*  830 */       this.trigger_buff_set.addAll(_o_.trigger_buff_set);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  836 */       _os_.marshal(this.world_id);
/*  837 */       _os_.marshal(this.chapter_cfg_id);
/*  838 */       _os_.marshal(this.process);
/*  839 */       _os_.marshal(this.session_id);
/*  840 */       _os_.compact_uint32(this.trigger_effect_map.size());
/*  841 */       for (Map.Entry<Integer, Integer> _e_ : this.trigger_effect_map.entrySet())
/*      */       {
/*  843 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  844 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  846 */       _os_.compact_uint32(this.trigger_buff_set.size());
/*  847 */       for (Integer _v_ : this.trigger_buff_set)
/*      */       {
/*  849 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  851 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  857 */       this.world_id = _os_.unmarshal_long();
/*  858 */       this.chapter_cfg_id = _os_.unmarshal_int();
/*  859 */       this.process = _os_.unmarshal_int();
/*  860 */       this.session_id = _os_.unmarshal_long();
/*      */       
/*  862 */       int size = _os_.uncompact_uint32();
/*  863 */       if (size >= 12)
/*      */       {
/*  865 */         this.trigger_effect_map = new HashMap(size * 2);
/*      */       }
/*  867 */       for (; size > 0; size--)
/*      */       {
/*  869 */         int _k_ = 0;
/*  870 */         _k_ = _os_.unmarshal_int();
/*  871 */         int _v_ = 0;
/*  872 */         _v_ = _os_.unmarshal_int();
/*  873 */         this.trigger_effect_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  876 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  878 */         int _v_ = 0;
/*  879 */         _v_ = _os_.unmarshal_int();
/*  880 */         this.trigger_buff_set.add(Integer.valueOf(_v_));
/*      */       }
/*  882 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  888 */       int _size_ = 0;
/*  889 */       _size_ += CodedOutputStream.computeInt64Size(1, this.world_id);
/*  890 */       _size_ += CodedOutputStream.computeInt32Size(2, this.chapter_cfg_id);
/*  891 */       _size_ += CodedOutputStream.computeInt32Size(3, this.process);
/*  892 */       _size_ += CodedOutputStream.computeInt64Size(4, this.session_id);
/*  893 */       for (Map.Entry<Integer, Integer> _e_ : this.trigger_effect_map.entrySet())
/*      */       {
/*  895 */         _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/*  896 */         _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  898 */       for (Integer _v_ : this.trigger_buff_set)
/*      */       {
/*  900 */         _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */       }
/*  902 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  910 */         _output_.writeInt64(1, this.world_id);
/*  911 */         _output_.writeInt32(2, this.chapter_cfg_id);
/*  912 */         _output_.writeInt32(3, this.process);
/*  913 */         _output_.writeInt64(4, this.session_id);
/*  914 */         for (Map.Entry<Integer, Integer> _e_ : this.trigger_effect_map.entrySet())
/*      */         {
/*  916 */           _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/*  917 */           _output_.writeInt32(5, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  919 */         for (Integer _v_ : this.trigger_buff_set)
/*      */         {
/*  921 */           _output_.writeInt32(6, _v_.intValue());
/*      */         }
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  926 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  928 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  936 */         boolean done = false;
/*  937 */         while (!done)
/*      */         {
/*  939 */           int tag = _input_.readTag();
/*  940 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  944 */             done = true;
/*  945 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  949 */             this.world_id = _input_.readInt64();
/*  950 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  954 */             this.chapter_cfg_id = _input_.readInt32();
/*  955 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  959 */             this.process = _input_.readInt32();
/*  960 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  964 */             this.session_id = _input_.readInt64();
/*  965 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  969 */             int _k_ = 0;
/*  970 */             _k_ = _input_.readInt32();
/*  971 */             int readTag = _input_.readTag();
/*  972 */             if (40 != readTag)
/*      */             {
/*  974 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  976 */             int _v_ = 0;
/*  977 */             _v_ = _input_.readInt32();
/*  978 */             this.trigger_effect_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  979 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  983 */             int _v_ = 0;
/*  984 */             _v_ = _input_.readInt32();
/*  985 */             this.trigger_buff_set.add(Integer.valueOf(_v_));
/*  986 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  990 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  992 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1001 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1005 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1007 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2TreasureHuntWorldInfo copy()
/*      */     {
/* 1013 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2TreasureHuntWorldInfo toData()
/*      */     {
/* 1019 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Role2TreasureHuntWorldInfo toBean()
/*      */     {
/* 1024 */       return new Role2TreasureHuntWorldInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2TreasureHuntWorldInfo toDataIf()
/*      */     {
/* 1030 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Role2TreasureHuntWorldInfo toBeanIf()
/*      */     {
/* 1035 */       return new Role2TreasureHuntWorldInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1041 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1045 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1049 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1053 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1057 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1061 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1065 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWorld_id()
/*      */     {
/* 1072 */       return this.world_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChapter_cfg_id()
/*      */     {
/* 1079 */       return this.chapter_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getProcess()
/*      */     {
/* 1086 */       return this.process;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSession_id()
/*      */     {
/* 1093 */       return this.session_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getTrigger_effect_map()
/*      */     {
/* 1100 */       return this.trigger_effect_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getTrigger_effect_mapAsData()
/*      */     {
/* 1107 */       return this.trigger_effect_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getTrigger_buff_set()
/*      */     {
/* 1114 */       return this.trigger_buff_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getTrigger_buff_setAsData()
/*      */     {
/* 1121 */       return this.trigger_buff_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorld_id(long _v_)
/*      */     {
/* 1128 */       this.world_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChapter_cfg_id(int _v_)
/*      */     {
/* 1135 */       this.chapter_cfg_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setProcess(int _v_)
/*      */     {
/* 1142 */       this.process = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSession_id(long _v_)
/*      */     {
/* 1149 */       this.session_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1155 */       if (!(_o1_ instanceof Data)) return false;
/* 1156 */       Data _o_ = (Data)_o1_;
/* 1157 */       if (this.world_id != _o_.world_id) return false;
/* 1158 */       if (this.chapter_cfg_id != _o_.chapter_cfg_id) return false;
/* 1159 */       if (this.process != _o_.process) return false;
/* 1160 */       if (this.session_id != _o_.session_id) return false;
/* 1161 */       if (!this.trigger_effect_map.equals(_o_.trigger_effect_map)) return false;
/* 1162 */       if (!this.trigger_buff_set.equals(_o_.trigger_buff_set)) return false;
/* 1163 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1169 */       int _h_ = 0;
/* 1170 */       _h_ = (int)(_h_ + this.world_id);
/* 1171 */       _h_ += this.chapter_cfg_id;
/* 1172 */       _h_ += this.process;
/* 1173 */       _h_ = (int)(_h_ + this.session_id);
/* 1174 */       _h_ += this.trigger_effect_map.hashCode();
/* 1175 */       _h_ += this.trigger_buff_set.hashCode();
/* 1176 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1182 */       StringBuilder _sb_ = new StringBuilder();
/* 1183 */       _sb_.append("(");
/* 1184 */       _sb_.append(this.world_id);
/* 1185 */       _sb_.append(",");
/* 1186 */       _sb_.append(this.chapter_cfg_id);
/* 1187 */       _sb_.append(",");
/* 1188 */       _sb_.append(this.process);
/* 1189 */       _sb_.append(",");
/* 1190 */       _sb_.append(this.session_id);
/* 1191 */       _sb_.append(",");
/* 1192 */       _sb_.append(this.trigger_effect_map);
/* 1193 */       _sb_.append(",");
/* 1194 */       _sb_.append(this.trigger_buff_set);
/* 1195 */       _sb_.append(")");
/* 1196 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2TreasureHuntWorldInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */