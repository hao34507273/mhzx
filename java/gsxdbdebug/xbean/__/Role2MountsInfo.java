/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import ppbio.Message;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ 
/*      */ public final class Role2MountsInfo extends XBean implements xbean.Role2MountsInfo
/*      */ {
/*      */   private HashMap<Long, xbean.MountsInfo> mounts_info_map;
/*      */   private HashMap<Integer, xbean.BattleMountsInfo> battle_mounts_info_map;
/*      */   private HashMap<Long, xbean.AppearenceMountsInfo> appearence_mounts_info_map;
/*      */   private long current_ride_mounts_id;
/*      */   private int current_chief_battle_mounts;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.mounts_info_map.clear();
/*   27 */     this.battle_mounts_info_map.clear();
/*   28 */     this.appearence_mounts_info_map.clear();
/*   29 */     this.current_ride_mounts_id = 0L;
/*   30 */     this.current_chief_battle_mounts = 0;
/*      */   }
/*      */   
/*      */   Role2MountsInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.mounts_info_map = new HashMap();
/*   37 */     this.battle_mounts_info_map = new HashMap();
/*   38 */     this.appearence_mounts_info_map = new HashMap();
/*      */   }
/*      */   
/*      */   public Role2MountsInfo()
/*      */   {
/*   43 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Role2MountsInfo(Role2MountsInfo _o_)
/*      */   {
/*   48 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Role2MountsInfo(xbean.Role2MountsInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     if ((_o1_ instanceof Role2MountsInfo)) { assign((Role2MountsInfo)_o1_);
/*   55 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   56 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   57 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Role2MountsInfo _o_) {
/*   62 */     _o_._xdb_verify_unsafe_();
/*   63 */     this.mounts_info_map = new HashMap();
/*   64 */     for (Map.Entry<Long, xbean.MountsInfo> _e_ : _o_.mounts_info_map.entrySet())
/*   65 */       this.mounts_info_map.put(_e_.getKey(), new MountsInfo((xbean.MountsInfo)_e_.getValue(), this, "mounts_info_map"));
/*   66 */     this.battle_mounts_info_map = new HashMap();
/*   67 */     for (Map.Entry<Integer, xbean.BattleMountsInfo> _e_ : _o_.battle_mounts_info_map.entrySet())
/*   68 */       this.battle_mounts_info_map.put(_e_.getKey(), new BattleMountsInfo((xbean.BattleMountsInfo)_e_.getValue(), this, "battle_mounts_info_map"));
/*   69 */     this.appearence_mounts_info_map = new HashMap();
/*   70 */     for (Map.Entry<Long, xbean.AppearenceMountsInfo> _e_ : _o_.appearence_mounts_info_map.entrySet())
/*   71 */       this.appearence_mounts_info_map.put(_e_.getKey(), new AppearenceMountsInfo((xbean.AppearenceMountsInfo)_e_.getValue(), this, "appearence_mounts_info_map"));
/*   72 */     this.current_ride_mounts_id = _o_.current_ride_mounts_id;
/*   73 */     this.current_chief_battle_mounts = _o_.current_chief_battle_mounts;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   78 */     this.mounts_info_map = new HashMap();
/*   79 */     for (Map.Entry<Long, xbean.MountsInfo> _e_ : _o_.mounts_info_map.entrySet())
/*   80 */       this.mounts_info_map.put(_e_.getKey(), new MountsInfo((xbean.MountsInfo)_e_.getValue(), this, "mounts_info_map"));
/*   81 */     this.battle_mounts_info_map = new HashMap();
/*   82 */     for (Map.Entry<Integer, xbean.BattleMountsInfo> _e_ : _o_.battle_mounts_info_map.entrySet())
/*   83 */       this.battle_mounts_info_map.put(_e_.getKey(), new BattleMountsInfo((xbean.BattleMountsInfo)_e_.getValue(), this, "battle_mounts_info_map"));
/*   84 */     this.appearence_mounts_info_map = new HashMap();
/*   85 */     for (Map.Entry<Long, xbean.AppearenceMountsInfo> _e_ : _o_.appearence_mounts_info_map.entrySet())
/*   86 */       this.appearence_mounts_info_map.put(_e_.getKey(), new AppearenceMountsInfo((xbean.AppearenceMountsInfo)_e_.getValue(), this, "appearence_mounts_info_map"));
/*   87 */     this.current_ride_mounts_id = _o_.current_ride_mounts_id;
/*   88 */     this.current_chief_battle_mounts = _o_.current_chief_battle_mounts;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   94 */     _xdb_verify_unsafe_();
/*   95 */     _os_.compact_uint32(this.mounts_info_map.size());
/*   96 */     for (Map.Entry<Long, xbean.MountsInfo> _e_ : this.mounts_info_map.entrySet())
/*      */     {
/*   98 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   99 */       ((xbean.MountsInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  101 */     _os_.compact_uint32(this.battle_mounts_info_map.size());
/*  102 */     for (Map.Entry<Integer, xbean.BattleMountsInfo> _e_ : this.battle_mounts_info_map.entrySet())
/*      */     {
/*  104 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  105 */       ((xbean.BattleMountsInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  107 */     _os_.compact_uint32(this.appearence_mounts_info_map.size());
/*  108 */     for (Map.Entry<Long, xbean.AppearenceMountsInfo> _e_ : this.appearence_mounts_info_map.entrySet())
/*      */     {
/*  110 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  111 */       ((xbean.AppearenceMountsInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  113 */     _os_.marshal(this.current_ride_mounts_id);
/*  114 */     _os_.marshal(this.current_chief_battle_mounts);
/*  115 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  121 */     _xdb_verify_unsafe_();
/*      */     
/*  123 */     int size = _os_.uncompact_uint32();
/*  124 */     if (size >= 12)
/*      */     {
/*  126 */       this.mounts_info_map = new HashMap(size * 2);
/*      */     }
/*  128 */     for (; size > 0; size--)
/*      */     {
/*  130 */       long _k_ = 0L;
/*  131 */       _k_ = _os_.unmarshal_long();
/*  132 */       xbean.MountsInfo _v_ = new MountsInfo(0, this, "mounts_info_map");
/*  133 */       _v_.unmarshal(_os_);
/*  134 */       this.mounts_info_map.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  138 */     int size = _os_.uncompact_uint32();
/*  139 */     if (size >= 12)
/*      */     {
/*  141 */       this.battle_mounts_info_map = new HashMap(size * 2);
/*      */     }
/*  143 */     for (; size > 0; size--)
/*      */     {
/*  145 */       int _k_ = 0;
/*  146 */       _k_ = _os_.unmarshal_int();
/*  147 */       xbean.BattleMountsInfo _v_ = new BattleMountsInfo(0, this, "battle_mounts_info_map");
/*  148 */       _v_.unmarshal(_os_);
/*  149 */       this.battle_mounts_info_map.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  153 */     int size = _os_.uncompact_uint32();
/*  154 */     if (size >= 12)
/*      */     {
/*  156 */       this.appearence_mounts_info_map = new HashMap(size * 2);
/*      */     }
/*  158 */     for (; size > 0; size--)
/*      */     {
/*  160 */       long _k_ = 0L;
/*  161 */       _k_ = _os_.unmarshal_long();
/*  162 */       xbean.AppearenceMountsInfo _v_ = new AppearenceMountsInfo(0, this, "appearence_mounts_info_map");
/*  163 */       _v_.unmarshal(_os_);
/*  164 */       this.appearence_mounts_info_map.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  167 */     this.current_ride_mounts_id = _os_.unmarshal_long();
/*  168 */     this.current_chief_battle_mounts = _os_.unmarshal_int();
/*  169 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  175 */     _xdb_verify_unsafe_();
/*  176 */     int _size_ = 0;
/*  177 */     for (Map.Entry<Long, xbean.MountsInfo> _e_ : this.mounts_info_map.entrySet())
/*      */     {
/*  179 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/*  180 */       _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */     }
/*  182 */     for (Map.Entry<Integer, xbean.BattleMountsInfo> _e_ : this.battle_mounts_info_map.entrySet())
/*      */     {
/*  184 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  185 */       _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getValue());
/*      */     }
/*  187 */     for (Map.Entry<Long, xbean.AppearenceMountsInfo> _e_ : this.appearence_mounts_info_map.entrySet())
/*      */     {
/*  189 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  190 */       _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*      */     }
/*  192 */     _size_ += CodedOutputStream.computeInt64Size(4, this.current_ride_mounts_id);
/*  193 */     _size_ += CodedOutputStream.computeInt32Size(5, this.current_chief_battle_mounts);
/*  194 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  200 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  203 */       for (Map.Entry<Long, xbean.MountsInfo> _e_ : this.mounts_info_map.entrySet())
/*      */       {
/*  205 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/*  206 */         _output_.writeMessage(1, (Message)_e_.getValue());
/*      */       }
/*  208 */       for (Map.Entry<Integer, xbean.BattleMountsInfo> _e_ : this.battle_mounts_info_map.entrySet())
/*      */       {
/*  210 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  211 */         _output_.writeMessage(2, (Message)_e_.getValue());
/*      */       }
/*  213 */       for (Map.Entry<Long, xbean.AppearenceMountsInfo> _e_ : this.appearence_mounts_info_map.entrySet())
/*      */       {
/*  215 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  216 */         _output_.writeMessage(3, (Message)_e_.getValue());
/*      */       }
/*  218 */       _output_.writeInt64(4, this.current_ride_mounts_id);
/*  219 */       _output_.writeInt32(5, this.current_chief_battle_mounts);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  223 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  225 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  231 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  234 */       boolean done = false;
/*  235 */       while (!done)
/*      */       {
/*  237 */         int tag = _input_.readTag();
/*  238 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  242 */           done = true;
/*  243 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  247 */           long _k_ = 0L;
/*  248 */           _k_ = _input_.readInt64();
/*  249 */           int readTag = _input_.readTag();
/*  250 */           if (10 != readTag)
/*      */           {
/*  252 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  254 */           xbean.MountsInfo _v_ = new MountsInfo(0, this, "mounts_info_map");
/*  255 */           _input_.readMessage(_v_);
/*  256 */           this.mounts_info_map.put(Long.valueOf(_k_), _v_);
/*  257 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  261 */           int _k_ = 0;
/*  262 */           _k_ = _input_.readInt32();
/*  263 */           int readTag = _input_.readTag();
/*  264 */           if (18 != readTag)
/*      */           {
/*  266 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  268 */           xbean.BattleMountsInfo _v_ = new BattleMountsInfo(0, this, "battle_mounts_info_map");
/*  269 */           _input_.readMessage(_v_);
/*  270 */           this.battle_mounts_info_map.put(Integer.valueOf(_k_), _v_);
/*  271 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  275 */           long _k_ = 0L;
/*  276 */           _k_ = _input_.readInt64();
/*  277 */           int readTag = _input_.readTag();
/*  278 */           if (26 != readTag)
/*      */           {
/*  280 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  282 */           xbean.AppearenceMountsInfo _v_ = new AppearenceMountsInfo(0, this, "appearence_mounts_info_map");
/*  283 */           _input_.readMessage(_v_);
/*  284 */           this.appearence_mounts_info_map.put(Long.valueOf(_k_), _v_);
/*  285 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  289 */           this.current_ride_mounts_id = _input_.readInt64();
/*  290 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  294 */           this.current_chief_battle_mounts = _input_.readInt32();
/*  295 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  299 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  301 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  310 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  314 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  316 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2MountsInfo copy()
/*      */   {
/*  322 */     _xdb_verify_unsafe_();
/*  323 */     return new Role2MountsInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2MountsInfo toData()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2MountsInfo toBean()
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*  336 */     return new Role2MountsInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2MountsInfo toDataIf()
/*      */   {
/*  342 */     _xdb_verify_unsafe_();
/*  343 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2MountsInfo toBeanIf()
/*      */   {
/*  348 */     _xdb_verify_unsafe_();
/*  349 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.MountsInfo> getMounts_info_map()
/*      */   {
/*  363 */     _xdb_verify_unsafe_();
/*  364 */     return xdb.Logs.logMap(new LogKey(this, "mounts_info_map"), this.mounts_info_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.MountsInfo> getMounts_info_mapAsData()
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*      */     
/*  373 */     Role2MountsInfo _o_ = this;
/*  374 */     Map<Long, xbean.MountsInfo> mounts_info_map = new HashMap();
/*  375 */     for (Map.Entry<Long, xbean.MountsInfo> _e_ : _o_.mounts_info_map.entrySet())
/*  376 */       mounts_info_map.put(_e_.getKey(), new MountsInfo.Data((xbean.MountsInfo)_e_.getValue()));
/*  377 */     return mounts_info_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.BattleMountsInfo> getBattle_mounts_info_map()
/*      */   {
/*  384 */     _xdb_verify_unsafe_();
/*  385 */     return xdb.Logs.logMap(new LogKey(this, "battle_mounts_info_map"), this.battle_mounts_info_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.BattleMountsInfo> getBattle_mounts_info_mapAsData()
/*      */   {
/*  392 */     _xdb_verify_unsafe_();
/*      */     
/*  394 */     Role2MountsInfo _o_ = this;
/*  395 */     Map<Integer, xbean.BattleMountsInfo> battle_mounts_info_map = new HashMap();
/*  396 */     for (Map.Entry<Integer, xbean.BattleMountsInfo> _e_ : _o_.battle_mounts_info_map.entrySet())
/*  397 */       battle_mounts_info_map.put(_e_.getKey(), new BattleMountsInfo.Data((xbean.BattleMountsInfo)_e_.getValue()));
/*  398 */     return battle_mounts_info_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.AppearenceMountsInfo> getAppearence_mounts_info_map()
/*      */   {
/*  405 */     _xdb_verify_unsafe_();
/*  406 */     return xdb.Logs.logMap(new LogKey(this, "appearence_mounts_info_map"), this.appearence_mounts_info_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.AppearenceMountsInfo> getAppearence_mounts_info_mapAsData()
/*      */   {
/*  413 */     _xdb_verify_unsafe_();
/*      */     
/*  415 */     Role2MountsInfo _o_ = this;
/*  416 */     Map<Long, xbean.AppearenceMountsInfo> appearence_mounts_info_map = new HashMap();
/*  417 */     for (Map.Entry<Long, xbean.AppearenceMountsInfo> _e_ : _o_.appearence_mounts_info_map.entrySet())
/*  418 */       appearence_mounts_info_map.put(_e_.getKey(), new AppearenceMountsInfo.Data((xbean.AppearenceMountsInfo)_e_.getValue()));
/*  419 */     return appearence_mounts_info_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCurrent_ride_mounts_id()
/*      */   {
/*  426 */     _xdb_verify_unsafe_();
/*  427 */     return this.current_ride_mounts_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_chief_battle_mounts()
/*      */   {
/*  434 */     _xdb_verify_unsafe_();
/*  435 */     return this.current_chief_battle_mounts;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_ride_mounts_id(long _v_)
/*      */   {
/*  442 */     _xdb_verify_unsafe_();
/*  443 */     xdb.Logs.logIf(new LogKey(this, "current_ride_mounts_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  447 */         new xdb.logs.LogLong(this, Role2MountsInfo.this.current_ride_mounts_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  451 */             Role2MountsInfo.this.current_ride_mounts_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  455 */     });
/*  456 */     this.current_ride_mounts_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_chief_battle_mounts(int _v_)
/*      */   {
/*  463 */     _xdb_verify_unsafe_();
/*  464 */     xdb.Logs.logIf(new LogKey(this, "current_chief_battle_mounts")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  468 */         new xdb.logs.LogInt(this, Role2MountsInfo.this.current_chief_battle_mounts)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  472 */             Role2MountsInfo.this.current_chief_battle_mounts = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  476 */     });
/*  477 */     this.current_chief_battle_mounts = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  483 */     _xdb_verify_unsafe_();
/*  484 */     Role2MountsInfo _o_ = null;
/*  485 */     if ((_o1_ instanceof Role2MountsInfo)) { _o_ = (Role2MountsInfo)_o1_;
/*  486 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  487 */       return false;
/*  488 */     if (!this.mounts_info_map.equals(_o_.mounts_info_map)) return false;
/*  489 */     if (!this.battle_mounts_info_map.equals(_o_.battle_mounts_info_map)) return false;
/*  490 */     if (!this.appearence_mounts_info_map.equals(_o_.appearence_mounts_info_map)) return false;
/*  491 */     if (this.current_ride_mounts_id != _o_.current_ride_mounts_id) return false;
/*  492 */     if (this.current_chief_battle_mounts != _o_.current_chief_battle_mounts) return false;
/*  493 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  499 */     _xdb_verify_unsafe_();
/*  500 */     int _h_ = 0;
/*  501 */     _h_ += this.mounts_info_map.hashCode();
/*  502 */     _h_ += this.battle_mounts_info_map.hashCode();
/*  503 */     _h_ += this.appearence_mounts_info_map.hashCode();
/*  504 */     _h_ = (int)(_h_ + this.current_ride_mounts_id);
/*  505 */     _h_ += this.current_chief_battle_mounts;
/*  506 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  512 */     _xdb_verify_unsafe_();
/*  513 */     StringBuilder _sb_ = new StringBuilder();
/*  514 */     _sb_.append("(");
/*  515 */     _sb_.append(this.mounts_info_map);
/*  516 */     _sb_.append(",");
/*  517 */     _sb_.append(this.battle_mounts_info_map);
/*  518 */     _sb_.append(",");
/*  519 */     _sb_.append(this.appearence_mounts_info_map);
/*  520 */     _sb_.append(",");
/*  521 */     _sb_.append(this.current_ride_mounts_id);
/*  522 */     _sb_.append(",");
/*  523 */     _sb_.append(this.current_chief_battle_mounts);
/*  524 */     _sb_.append(")");
/*  525 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  531 */     ListenableBean lb = new ListenableBean();
/*  532 */     lb.add(new xdb.logs.ListenableMap().setVarName("mounts_info_map"));
/*  533 */     lb.add(new xdb.logs.ListenableMap().setVarName("battle_mounts_info_map"));
/*  534 */     lb.add(new xdb.logs.ListenableMap().setVarName("appearence_mounts_info_map"));
/*  535 */     lb.add(new xdb.logs.ListenableChanged().setVarName("current_ride_mounts_id"));
/*  536 */     lb.add(new xdb.logs.ListenableChanged().setVarName("current_chief_battle_mounts"));
/*  537 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Role2MountsInfo {
/*      */     private Const() {}
/*      */     
/*      */     Role2MountsInfo nThis() {
/*  544 */       return Role2MountsInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  550 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2MountsInfo copy()
/*      */     {
/*  556 */       return Role2MountsInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2MountsInfo toData()
/*      */     {
/*  562 */       return Role2MountsInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Role2MountsInfo toBean()
/*      */     {
/*  567 */       return Role2MountsInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2MountsInfo toDataIf()
/*      */     {
/*  573 */       return Role2MountsInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Role2MountsInfo toBeanIf()
/*      */     {
/*  578 */       return Role2MountsInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MountsInfo> getMounts_info_map()
/*      */     {
/*  585 */       Role2MountsInfo.this._xdb_verify_unsafe_();
/*  586 */       return xdb.Consts.constMap(Role2MountsInfo.this.mounts_info_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MountsInfo> getMounts_info_mapAsData()
/*      */     {
/*  593 */       Role2MountsInfo.this._xdb_verify_unsafe_();
/*      */       
/*  595 */       Role2MountsInfo _o_ = Role2MountsInfo.this;
/*  596 */       Map<Long, xbean.MountsInfo> mounts_info_map = new HashMap();
/*  597 */       for (Map.Entry<Long, xbean.MountsInfo> _e_ : _o_.mounts_info_map.entrySet())
/*  598 */         mounts_info_map.put(_e_.getKey(), new MountsInfo.Data((xbean.MountsInfo)_e_.getValue()));
/*  599 */       return mounts_info_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BattleMountsInfo> getBattle_mounts_info_map()
/*      */     {
/*  606 */       Role2MountsInfo.this._xdb_verify_unsafe_();
/*  607 */       return xdb.Consts.constMap(Role2MountsInfo.this.battle_mounts_info_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BattleMountsInfo> getBattle_mounts_info_mapAsData()
/*      */     {
/*  614 */       Role2MountsInfo.this._xdb_verify_unsafe_();
/*      */       
/*  616 */       Role2MountsInfo _o_ = Role2MountsInfo.this;
/*  617 */       Map<Integer, xbean.BattleMountsInfo> battle_mounts_info_map = new HashMap();
/*  618 */       for (Map.Entry<Integer, xbean.BattleMountsInfo> _e_ : _o_.battle_mounts_info_map.entrySet())
/*  619 */         battle_mounts_info_map.put(_e_.getKey(), new BattleMountsInfo.Data((xbean.BattleMountsInfo)_e_.getValue()));
/*  620 */       return battle_mounts_info_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.AppearenceMountsInfo> getAppearence_mounts_info_map()
/*      */     {
/*  627 */       Role2MountsInfo.this._xdb_verify_unsafe_();
/*  628 */       return xdb.Consts.constMap(Role2MountsInfo.this.appearence_mounts_info_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.AppearenceMountsInfo> getAppearence_mounts_info_mapAsData()
/*      */     {
/*  635 */       Role2MountsInfo.this._xdb_verify_unsafe_();
/*      */       
/*  637 */       Role2MountsInfo _o_ = Role2MountsInfo.this;
/*  638 */       Map<Long, xbean.AppearenceMountsInfo> appearence_mounts_info_map = new HashMap();
/*  639 */       for (Map.Entry<Long, xbean.AppearenceMountsInfo> _e_ : _o_.appearence_mounts_info_map.entrySet())
/*  640 */         appearence_mounts_info_map.put(_e_.getKey(), new AppearenceMountsInfo.Data((xbean.AppearenceMountsInfo)_e_.getValue()));
/*  641 */       return appearence_mounts_info_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCurrent_ride_mounts_id()
/*      */     {
/*  648 */       Role2MountsInfo.this._xdb_verify_unsafe_();
/*  649 */       return Role2MountsInfo.this.current_ride_mounts_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_chief_battle_mounts()
/*      */     {
/*  656 */       Role2MountsInfo.this._xdb_verify_unsafe_();
/*  657 */       return Role2MountsInfo.this.current_chief_battle_mounts;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_ride_mounts_id(long _v_)
/*      */     {
/*  664 */       Role2MountsInfo.this._xdb_verify_unsafe_();
/*  665 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_chief_battle_mounts(int _v_)
/*      */     {
/*  672 */       Role2MountsInfo.this._xdb_verify_unsafe_();
/*  673 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  679 */       Role2MountsInfo.this._xdb_verify_unsafe_();
/*  680 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  686 */       Role2MountsInfo.this._xdb_verify_unsafe_();
/*  687 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  693 */       return Role2MountsInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  699 */       return Role2MountsInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  705 */       Role2MountsInfo.this._xdb_verify_unsafe_();
/*  706 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  712 */       return Role2MountsInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  718 */       return Role2MountsInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  724 */       Role2MountsInfo.this._xdb_verify_unsafe_();
/*  725 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  731 */       return Role2MountsInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  737 */       return Role2MountsInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  743 */       return Role2MountsInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  749 */       return Role2MountsInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  755 */       return Role2MountsInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  761 */       return Role2MountsInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  767 */       return Role2MountsInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Role2MountsInfo
/*      */   {
/*      */     private HashMap<Long, xbean.MountsInfo> mounts_info_map;
/*      */     
/*      */     private HashMap<Integer, xbean.BattleMountsInfo> battle_mounts_info_map;
/*      */     
/*      */     private HashMap<Long, xbean.AppearenceMountsInfo> appearence_mounts_info_map;
/*      */     
/*      */     private long current_ride_mounts_id;
/*      */     
/*      */     private int current_chief_battle_mounts;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  787 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  792 */       this.mounts_info_map = new HashMap();
/*  793 */       this.battle_mounts_info_map = new HashMap();
/*  794 */       this.appearence_mounts_info_map = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.Role2MountsInfo _o1_)
/*      */     {
/*  799 */       if ((_o1_ instanceof Role2MountsInfo)) { assign((Role2MountsInfo)_o1_);
/*  800 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  801 */       } else if ((_o1_ instanceof Role2MountsInfo.Const)) assign(((Role2MountsInfo.Const)_o1_).nThis()); else {
/*  802 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Role2MountsInfo _o_) {
/*  807 */       this.mounts_info_map = new HashMap();
/*  808 */       for (Map.Entry<Long, xbean.MountsInfo> _e_ : _o_.mounts_info_map.entrySet())
/*  809 */         this.mounts_info_map.put(_e_.getKey(), new MountsInfo.Data((xbean.MountsInfo)_e_.getValue()));
/*  810 */       this.battle_mounts_info_map = new HashMap();
/*  811 */       for (Map.Entry<Integer, xbean.BattleMountsInfo> _e_ : _o_.battle_mounts_info_map.entrySet())
/*  812 */         this.battle_mounts_info_map.put(_e_.getKey(), new BattleMountsInfo.Data((xbean.BattleMountsInfo)_e_.getValue()));
/*  813 */       this.appearence_mounts_info_map = new HashMap();
/*  814 */       for (Map.Entry<Long, xbean.AppearenceMountsInfo> _e_ : _o_.appearence_mounts_info_map.entrySet())
/*  815 */         this.appearence_mounts_info_map.put(_e_.getKey(), new AppearenceMountsInfo.Data((xbean.AppearenceMountsInfo)_e_.getValue()));
/*  816 */       this.current_ride_mounts_id = _o_.current_ride_mounts_id;
/*  817 */       this.current_chief_battle_mounts = _o_.current_chief_battle_mounts;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  822 */       this.mounts_info_map = new HashMap();
/*  823 */       for (Map.Entry<Long, xbean.MountsInfo> _e_ : _o_.mounts_info_map.entrySet())
/*  824 */         this.mounts_info_map.put(_e_.getKey(), new MountsInfo.Data((xbean.MountsInfo)_e_.getValue()));
/*  825 */       this.battle_mounts_info_map = new HashMap();
/*  826 */       for (Map.Entry<Integer, xbean.BattleMountsInfo> _e_ : _o_.battle_mounts_info_map.entrySet())
/*  827 */         this.battle_mounts_info_map.put(_e_.getKey(), new BattleMountsInfo.Data((xbean.BattleMountsInfo)_e_.getValue()));
/*  828 */       this.appearence_mounts_info_map = new HashMap();
/*  829 */       for (Map.Entry<Long, xbean.AppearenceMountsInfo> _e_ : _o_.appearence_mounts_info_map.entrySet())
/*  830 */         this.appearence_mounts_info_map.put(_e_.getKey(), new AppearenceMountsInfo.Data((xbean.AppearenceMountsInfo)_e_.getValue()));
/*  831 */       this.current_ride_mounts_id = _o_.current_ride_mounts_id;
/*  832 */       this.current_chief_battle_mounts = _o_.current_chief_battle_mounts;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  838 */       _os_.compact_uint32(this.mounts_info_map.size());
/*  839 */       for (Map.Entry<Long, xbean.MountsInfo> _e_ : this.mounts_info_map.entrySet())
/*      */       {
/*  841 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  842 */         ((xbean.MountsInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  844 */       _os_.compact_uint32(this.battle_mounts_info_map.size());
/*  845 */       for (Map.Entry<Integer, xbean.BattleMountsInfo> _e_ : this.battle_mounts_info_map.entrySet())
/*      */       {
/*  847 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  848 */         ((xbean.BattleMountsInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  850 */       _os_.compact_uint32(this.appearence_mounts_info_map.size());
/*  851 */       for (Map.Entry<Long, xbean.AppearenceMountsInfo> _e_ : this.appearence_mounts_info_map.entrySet())
/*      */       {
/*  853 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  854 */         ((xbean.AppearenceMountsInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  856 */       _os_.marshal(this.current_ride_mounts_id);
/*  857 */       _os_.marshal(this.current_chief_battle_mounts);
/*  858 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  865 */       int size = _os_.uncompact_uint32();
/*  866 */       if (size >= 12)
/*      */       {
/*  868 */         this.mounts_info_map = new HashMap(size * 2);
/*      */       }
/*  870 */       for (; size > 0; size--)
/*      */       {
/*  872 */         long _k_ = 0L;
/*  873 */         _k_ = _os_.unmarshal_long();
/*  874 */         xbean.MountsInfo _v_ = xbean.Pod.newMountsInfoData();
/*  875 */         _v_.unmarshal(_os_);
/*  876 */         this.mounts_info_map.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/*  880 */       int size = _os_.uncompact_uint32();
/*  881 */       if (size >= 12)
/*      */       {
/*  883 */         this.battle_mounts_info_map = new HashMap(size * 2);
/*      */       }
/*  885 */       for (; size > 0; size--)
/*      */       {
/*  887 */         int _k_ = 0;
/*  888 */         _k_ = _os_.unmarshal_int();
/*  889 */         xbean.BattleMountsInfo _v_ = xbean.Pod.newBattleMountsInfoData();
/*  890 */         _v_.unmarshal(_os_);
/*  891 */         this.battle_mounts_info_map.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/*  895 */       int size = _os_.uncompact_uint32();
/*  896 */       if (size >= 12)
/*      */       {
/*  898 */         this.appearence_mounts_info_map = new HashMap(size * 2);
/*      */       }
/*  900 */       for (; size > 0; size--)
/*      */       {
/*  902 */         long _k_ = 0L;
/*  903 */         _k_ = _os_.unmarshal_long();
/*  904 */         xbean.AppearenceMountsInfo _v_ = xbean.Pod.newAppearenceMountsInfoData();
/*  905 */         _v_.unmarshal(_os_);
/*  906 */         this.appearence_mounts_info_map.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  909 */       this.current_ride_mounts_id = _os_.unmarshal_long();
/*  910 */       this.current_chief_battle_mounts = _os_.unmarshal_int();
/*  911 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  917 */       int _size_ = 0;
/*  918 */       for (Map.Entry<Long, xbean.MountsInfo> _e_ : this.mounts_info_map.entrySet())
/*      */       {
/*  920 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/*  921 */         _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */       }
/*  923 */       for (Map.Entry<Integer, xbean.BattleMountsInfo> _e_ : this.battle_mounts_info_map.entrySet())
/*      */       {
/*  925 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  926 */         _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getValue());
/*      */       }
/*  928 */       for (Map.Entry<Long, xbean.AppearenceMountsInfo> _e_ : this.appearence_mounts_info_map.entrySet())
/*      */       {
/*  930 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  931 */         _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*      */       }
/*  933 */       _size_ += CodedOutputStream.computeInt64Size(4, this.current_ride_mounts_id);
/*  934 */       _size_ += CodedOutputStream.computeInt32Size(5, this.current_chief_battle_mounts);
/*  935 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  943 */         for (Map.Entry<Long, xbean.MountsInfo> _e_ : this.mounts_info_map.entrySet())
/*      */         {
/*  945 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/*  946 */           _output_.writeMessage(1, (Message)_e_.getValue());
/*      */         }
/*  948 */         for (Map.Entry<Integer, xbean.BattleMountsInfo> _e_ : this.battle_mounts_info_map.entrySet())
/*      */         {
/*  950 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  951 */           _output_.writeMessage(2, (Message)_e_.getValue());
/*      */         }
/*  953 */         for (Map.Entry<Long, xbean.AppearenceMountsInfo> _e_ : this.appearence_mounts_info_map.entrySet())
/*      */         {
/*  955 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  956 */           _output_.writeMessage(3, (Message)_e_.getValue());
/*      */         }
/*  958 */         _output_.writeInt64(4, this.current_ride_mounts_id);
/*  959 */         _output_.writeInt32(5, this.current_chief_battle_mounts);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  963 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  965 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  973 */         boolean done = false;
/*  974 */         while (!done)
/*      */         {
/*  976 */           int tag = _input_.readTag();
/*  977 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  981 */             done = true;
/*  982 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  986 */             long _k_ = 0L;
/*  987 */             _k_ = _input_.readInt64();
/*  988 */             int readTag = _input_.readTag();
/*  989 */             if (10 != readTag)
/*      */             {
/*  991 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  993 */             xbean.MountsInfo _v_ = xbean.Pod.newMountsInfoData();
/*  994 */             _input_.readMessage(_v_);
/*  995 */             this.mounts_info_map.put(Long.valueOf(_k_), _v_);
/*  996 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1000 */             int _k_ = 0;
/* 1001 */             _k_ = _input_.readInt32();
/* 1002 */             int readTag = _input_.readTag();
/* 1003 */             if (18 != readTag)
/*      */             {
/* 1005 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1007 */             xbean.BattleMountsInfo _v_ = xbean.Pod.newBattleMountsInfoData();
/* 1008 */             _input_.readMessage(_v_);
/* 1009 */             this.battle_mounts_info_map.put(Integer.valueOf(_k_), _v_);
/* 1010 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1014 */             long _k_ = 0L;
/* 1015 */             _k_ = _input_.readInt64();
/* 1016 */             int readTag = _input_.readTag();
/* 1017 */             if (26 != readTag)
/*      */             {
/* 1019 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1021 */             xbean.AppearenceMountsInfo _v_ = xbean.Pod.newAppearenceMountsInfoData();
/* 1022 */             _input_.readMessage(_v_);
/* 1023 */             this.appearence_mounts_info_map.put(Long.valueOf(_k_), _v_);
/* 1024 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1028 */             this.current_ride_mounts_id = _input_.readInt64();
/* 1029 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1033 */             this.current_chief_battle_mounts = _input_.readInt32();
/* 1034 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1038 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1040 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1049 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1053 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1055 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2MountsInfo copy()
/*      */     {
/* 1061 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2MountsInfo toData()
/*      */     {
/* 1067 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Role2MountsInfo toBean()
/*      */     {
/* 1072 */       return new Role2MountsInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2MountsInfo toDataIf()
/*      */     {
/* 1078 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Role2MountsInfo toBeanIf()
/*      */     {
/* 1083 */       return new Role2MountsInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1089 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1093 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1097 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1101 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1105 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1109 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1113 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MountsInfo> getMounts_info_map()
/*      */     {
/* 1120 */       return this.mounts_info_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MountsInfo> getMounts_info_mapAsData()
/*      */     {
/* 1127 */       return this.mounts_info_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BattleMountsInfo> getBattle_mounts_info_map()
/*      */     {
/* 1134 */       return this.battle_mounts_info_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BattleMountsInfo> getBattle_mounts_info_mapAsData()
/*      */     {
/* 1141 */       return this.battle_mounts_info_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.AppearenceMountsInfo> getAppearence_mounts_info_map()
/*      */     {
/* 1148 */       return this.appearence_mounts_info_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.AppearenceMountsInfo> getAppearence_mounts_info_mapAsData()
/*      */     {
/* 1155 */       return this.appearence_mounts_info_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCurrent_ride_mounts_id()
/*      */     {
/* 1162 */       return this.current_ride_mounts_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_chief_battle_mounts()
/*      */     {
/* 1169 */       return this.current_chief_battle_mounts;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_ride_mounts_id(long _v_)
/*      */     {
/* 1176 */       this.current_ride_mounts_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_chief_battle_mounts(int _v_)
/*      */     {
/* 1183 */       this.current_chief_battle_mounts = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1189 */       if (!(_o1_ instanceof Data)) return false;
/* 1190 */       Data _o_ = (Data)_o1_;
/* 1191 */       if (!this.mounts_info_map.equals(_o_.mounts_info_map)) return false;
/* 1192 */       if (!this.battle_mounts_info_map.equals(_o_.battle_mounts_info_map)) return false;
/* 1193 */       if (!this.appearence_mounts_info_map.equals(_o_.appearence_mounts_info_map)) return false;
/* 1194 */       if (this.current_ride_mounts_id != _o_.current_ride_mounts_id) return false;
/* 1195 */       if (this.current_chief_battle_mounts != _o_.current_chief_battle_mounts) return false;
/* 1196 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1202 */       int _h_ = 0;
/* 1203 */       _h_ += this.mounts_info_map.hashCode();
/* 1204 */       _h_ += this.battle_mounts_info_map.hashCode();
/* 1205 */       _h_ += this.appearence_mounts_info_map.hashCode();
/* 1206 */       _h_ = (int)(_h_ + this.current_ride_mounts_id);
/* 1207 */       _h_ += this.current_chief_battle_mounts;
/* 1208 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1214 */       StringBuilder _sb_ = new StringBuilder();
/* 1215 */       _sb_.append("(");
/* 1216 */       _sb_.append(this.mounts_info_map);
/* 1217 */       _sb_.append(",");
/* 1218 */       _sb_.append(this.battle_mounts_info_map);
/* 1219 */       _sb_.append(",");
/* 1220 */       _sb_.append(this.appearence_mounts_info_map);
/* 1221 */       _sb_.append(",");
/* 1222 */       _sb_.append(this.current_ride_mounts_id);
/* 1223 */       _sb_.append(",");
/* 1224 */       _sb_.append(this.current_chief_battle_mounts);
/* 1225 */       _sb_.append(")");
/* 1226 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2MountsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */