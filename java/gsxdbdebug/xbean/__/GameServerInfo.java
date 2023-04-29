/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.util.HashMap;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class GameServerInfo extends XBean implements xbean.GameServerInfo
/*      */ {
/*      */   private LinkedList<String> zoneids;
/*      */   private int db_version;
/*      */   private long time_offset;
/*      */   private String gsxdb_jar_md5;
/*      */   private xbean.DisableProtocolInfo disable_protocol_info;
/*      */   private HashMap<Integer, xbean.ModuleFunSwitches> module_fun_switches;
/*      */   private long open_server_timestamp;
/*      */   private int create_role_num;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.zoneids.clear();
/*   33 */     this.db_version = 1;
/*   34 */     this.time_offset = 0L;
/*   35 */     this.gsxdb_jar_md5 = "";
/*   36 */     this.disable_protocol_info._reset_unsafe_();
/*   37 */     this.module_fun_switches.clear();
/*   38 */     this.open_server_timestamp = 0L;
/*   39 */     this.create_role_num = 0;
/*      */   }
/*      */   
/*      */   GameServerInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*   45 */     this.zoneids = new LinkedList();
/*   46 */     this.db_version = 1;
/*   47 */     this.time_offset = 0L;
/*   48 */     this.gsxdb_jar_md5 = "";
/*   49 */     this.disable_protocol_info = new DisableProtocolInfo(0, this, "disable_protocol_info");
/*   50 */     this.module_fun_switches = new HashMap();
/*      */   }
/*      */   
/*      */   public GameServerInfo()
/*      */   {
/*   55 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public GameServerInfo(GameServerInfo _o_)
/*      */   {
/*   60 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   GameServerInfo(xbean.GameServerInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   65 */     super(_xp_, _vn_);
/*   66 */     if ((_o1_ instanceof GameServerInfo)) { assign((GameServerInfo)_o1_);
/*   67 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   68 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   69 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(GameServerInfo _o_) {
/*   74 */     _o_._xdb_verify_unsafe_();
/*   75 */     this.zoneids = new LinkedList();
/*   76 */     this.zoneids.addAll(_o_.zoneids);
/*   77 */     this.db_version = _o_.db_version;
/*   78 */     this.time_offset = _o_.time_offset;
/*   79 */     this.gsxdb_jar_md5 = _o_.gsxdb_jar_md5;
/*   80 */     this.disable_protocol_info = new DisableProtocolInfo(_o_.disable_protocol_info, this, "disable_protocol_info");
/*   81 */     this.module_fun_switches = new HashMap();
/*   82 */     for (Map.Entry<Integer, xbean.ModuleFunSwitches> _e_ : _o_.module_fun_switches.entrySet())
/*   83 */       this.module_fun_switches.put(_e_.getKey(), new ModuleFunSwitches((xbean.ModuleFunSwitches)_e_.getValue(), this, "module_fun_switches"));
/*   84 */     this.open_server_timestamp = _o_.open_server_timestamp;
/*   85 */     this.create_role_num = _o_.create_role_num;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   90 */     this.zoneids = new LinkedList();
/*   91 */     this.zoneids.addAll(_o_.zoneids);
/*   92 */     this.db_version = _o_.db_version;
/*   93 */     this.time_offset = _o_.time_offset;
/*   94 */     this.gsxdb_jar_md5 = _o_.gsxdb_jar_md5;
/*   95 */     this.disable_protocol_info = new DisableProtocolInfo(_o_.disable_protocol_info, this, "disable_protocol_info");
/*   96 */     this.module_fun_switches = new HashMap();
/*   97 */     for (Map.Entry<Integer, xbean.ModuleFunSwitches> _e_ : _o_.module_fun_switches.entrySet())
/*   98 */       this.module_fun_switches.put(_e_.getKey(), new ModuleFunSwitches((xbean.ModuleFunSwitches)_e_.getValue(), this, "module_fun_switches"));
/*   99 */     this.open_server_timestamp = _o_.open_server_timestamp;
/*  100 */     this.create_role_num = _o_.create_role_num;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  106 */     _xdb_verify_unsafe_();
/*  107 */     _os_.compact_uint32(this.zoneids.size());
/*  108 */     for (String _v_ : this.zoneids)
/*      */     {
/*  110 */       _os_.marshal(_v_, "UTF-16LE");
/*      */     }
/*  112 */     _os_.marshal(this.db_version);
/*  113 */     _os_.marshal(this.time_offset);
/*  114 */     _os_.marshal(this.gsxdb_jar_md5, "UTF-16LE");
/*  115 */     this.disable_protocol_info.marshal(_os_);
/*  116 */     _os_.compact_uint32(this.module_fun_switches.size());
/*  117 */     for (Map.Entry<Integer, xbean.ModuleFunSwitches> _e_ : this.module_fun_switches.entrySet())
/*      */     {
/*  119 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  120 */       ((xbean.ModuleFunSwitches)_e_.getValue()).marshal(_os_);
/*      */     }
/*  122 */     _os_.marshal(this.open_server_timestamp);
/*  123 */     _os_.marshal(this.create_role_num);
/*  124 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  130 */     _xdb_verify_unsafe_();
/*  131 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  133 */       String _v_ = "";
/*  134 */       _v_ = _os_.unmarshal_String("UTF-16LE");
/*  135 */       this.zoneids.add(_v_);
/*      */     }
/*  137 */     this.db_version = _os_.unmarshal_int();
/*  138 */     this.time_offset = _os_.unmarshal_long();
/*  139 */     this.gsxdb_jar_md5 = _os_.unmarshal_String("UTF-16LE");
/*  140 */     this.disable_protocol_info.unmarshal(_os_);
/*      */     
/*  142 */     int size = _os_.uncompact_uint32();
/*  143 */     if (size >= 12)
/*      */     {
/*  145 */       this.module_fun_switches = new HashMap(size * 2);
/*      */     }
/*  147 */     for (; size > 0; size--)
/*      */     {
/*  149 */       int _k_ = 0;
/*  150 */       _k_ = _os_.unmarshal_int();
/*  151 */       xbean.ModuleFunSwitches _v_ = new ModuleFunSwitches(0, this, "module_fun_switches");
/*  152 */       _v_.unmarshal(_os_);
/*  153 */       this.module_fun_switches.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  156 */     this.open_server_timestamp = _os_.unmarshal_long();
/*  157 */     this.create_role_num = _os_.unmarshal_int();
/*  158 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  164 */     _xdb_verify_unsafe_();
/*  165 */     int _size_ = 0;
/*  166 */     for (String _v_ : this.zoneids)
/*      */     {
/*      */       try
/*      */       {
/*  170 */         _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(_v_, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  174 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */     }
/*  177 */     _size_ += CodedOutputStream.computeInt32Size(2, this.db_version);
/*  178 */     _size_ += CodedOutputStream.computeInt64Size(3, this.time_offset);
/*      */     try
/*      */     {
/*  181 */       _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.gsxdb_jar_md5, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  185 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  187 */     _size_ += CodedOutputStream.computeMessageSize(5, this.disable_protocol_info);
/*  188 */     for (Map.Entry<Integer, xbean.ModuleFunSwitches> _e_ : this.module_fun_switches.entrySet())
/*      */     {
/*  190 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/*  191 */       _size_ += CodedOutputStream.computeMessageSize(6, (ppbio.Message)_e_.getValue());
/*      */     }
/*  193 */     _size_ += CodedOutputStream.computeInt64Size(7, this.open_server_timestamp);
/*  194 */     _size_ += CodedOutputStream.computeInt32Size(8, this.create_role_num);
/*  195 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  201 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  204 */       for (String _v_ : this.zoneids)
/*      */       {
/*  206 */         _output_.writeBytes(1, ByteString.copyFrom(_v_, "UTF-16LE"));
/*      */       }
/*  208 */       _output_.writeInt32(2, this.db_version);
/*  209 */       _output_.writeInt64(3, this.time_offset);
/*  210 */       _output_.writeBytes(4, ByteString.copyFrom(this.gsxdb_jar_md5, "UTF-16LE"));
/*  211 */       _output_.writeMessage(5, this.disable_protocol_info);
/*  212 */       for (Map.Entry<Integer, xbean.ModuleFunSwitches> _e_ : this.module_fun_switches.entrySet())
/*      */       {
/*  214 */         _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/*  215 */         _output_.writeMessage(6, (ppbio.Message)_e_.getValue());
/*      */       }
/*  217 */       _output_.writeInt64(7, this.open_server_timestamp);
/*  218 */       _output_.writeInt32(8, this.create_role_num);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  222 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  224 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  230 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  233 */       boolean done = false;
/*  234 */       while (!done)
/*      */       {
/*  236 */         int tag = _input_.readTag();
/*  237 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  241 */           done = true;
/*  242 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  246 */           String _v_ = "";
/*  247 */           _v_ = _input_.readBytes().toString("UTF-16LE");
/*  248 */           this.zoneids.add(_v_);
/*  249 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  253 */           this.db_version = _input_.readInt32();
/*  254 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  258 */           this.time_offset = _input_.readInt64();
/*  259 */           break;
/*      */         
/*      */ 
/*      */         case 34: 
/*  263 */           this.gsxdb_jar_md5 = _input_.readBytes().toString("UTF-16LE");
/*  264 */           break;
/*      */         
/*      */ 
/*      */         case 42: 
/*  268 */           _input_.readMessage(this.disable_protocol_info);
/*  269 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  273 */           int _k_ = 0;
/*  274 */           _k_ = _input_.readInt32();
/*  275 */           int readTag = _input_.readTag();
/*  276 */           if (50 != readTag)
/*      */           {
/*  278 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  280 */           xbean.ModuleFunSwitches _v_ = new ModuleFunSwitches(0, this, "module_fun_switches");
/*  281 */           _input_.readMessage(_v_);
/*  282 */           this.module_fun_switches.put(Integer.valueOf(_k_), _v_);
/*  283 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  287 */           this.open_server_timestamp = _input_.readInt64();
/*  288 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  292 */           this.create_role_num = _input_.readInt32();
/*  293 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  297 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  299 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  308 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  312 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  314 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GameServerInfo copy()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return new GameServerInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GameServerInfo toData()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*  328 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.GameServerInfo toBean()
/*      */   {
/*  333 */     _xdb_verify_unsafe_();
/*  334 */     return new GameServerInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GameServerInfo toDataIf()
/*      */   {
/*  340 */     _xdb_verify_unsafe_();
/*  341 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.GameServerInfo toBeanIf()
/*      */   {
/*  346 */     _xdb_verify_unsafe_();
/*  347 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  353 */     _xdb_verify_unsafe_();
/*  354 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<String> getZoneids()
/*      */   {
/*  361 */     _xdb_verify_unsafe_();
/*  362 */     return xdb.Logs.logList(new LogKey(this, "zoneids"), this.zoneids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<String> getZoneidsAsData()
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*      */     
/*  370 */     GameServerInfo _o_ = this;
/*  371 */     List<String> zoneids = new LinkedList();
/*  372 */     zoneids.addAll(_o_.zoneids);
/*  373 */     return zoneids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDb_version()
/*      */   {
/*  380 */     _xdb_verify_unsafe_();
/*  381 */     return this.db_version;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTime_offset()
/*      */   {
/*  388 */     _xdb_verify_unsafe_();
/*  389 */     return this.time_offset;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getGsxdb_jar_md5()
/*      */   {
/*  396 */     _xdb_verify_unsafe_();
/*  397 */     return this.gsxdb_jar_md5;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getGsxdb_jar_md5Octets()
/*      */   {
/*  404 */     _xdb_verify_unsafe_();
/*  405 */     return Octets.wrap(getGsxdb_jar_md5(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.DisableProtocolInfo getDisable_protocol_info()
/*      */   {
/*  412 */     _xdb_verify_unsafe_();
/*  413 */     return this.disable_protocol_info;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.ModuleFunSwitches> getModule_fun_switches()
/*      */   {
/*  420 */     _xdb_verify_unsafe_();
/*  421 */     return xdb.Logs.logMap(new LogKey(this, "module_fun_switches"), this.module_fun_switches);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.ModuleFunSwitches> getModule_fun_switchesAsData()
/*      */   {
/*  428 */     _xdb_verify_unsafe_();
/*      */     
/*  430 */     GameServerInfo _o_ = this;
/*  431 */     Map<Integer, xbean.ModuleFunSwitches> module_fun_switches = new HashMap();
/*  432 */     for (Map.Entry<Integer, xbean.ModuleFunSwitches> _e_ : _o_.module_fun_switches.entrySet())
/*  433 */       module_fun_switches.put(_e_.getKey(), new ModuleFunSwitches.Data((xbean.ModuleFunSwitches)_e_.getValue()));
/*  434 */     return module_fun_switches;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getOpen_server_timestamp()
/*      */   {
/*  441 */     _xdb_verify_unsafe_();
/*  442 */     return this.open_server_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCreate_role_num()
/*      */   {
/*  449 */     _xdb_verify_unsafe_();
/*  450 */     return this.create_role_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDb_version(int _v_)
/*      */   {
/*  457 */     _xdb_verify_unsafe_();
/*  458 */     xdb.Logs.logIf(new LogKey(this, "db_version")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  462 */         new xdb.logs.LogInt(this, GameServerInfo.this.db_version)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  466 */             GameServerInfo.this.db_version = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  470 */     });
/*  471 */     this.db_version = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTime_offset(long _v_)
/*      */   {
/*  478 */     _xdb_verify_unsafe_();
/*  479 */     xdb.Logs.logIf(new LogKey(this, "time_offset")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  483 */         new xdb.logs.LogLong(this, GameServerInfo.this.time_offset)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  487 */             GameServerInfo.this.time_offset = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  491 */     });
/*  492 */     this.time_offset = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGsxdb_jar_md5(String _v_)
/*      */   {
/*  499 */     _xdb_verify_unsafe_();
/*  500 */     if (null == _v_)
/*  501 */       throw new NullPointerException();
/*  502 */     xdb.Logs.logIf(new LogKey(this, "gsxdb_jar_md5")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  506 */         new xdb.logs.LogString(this, GameServerInfo.this.gsxdb_jar_md5)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  510 */             GameServerInfo.this.gsxdb_jar_md5 = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  514 */     });
/*  515 */     this.gsxdb_jar_md5 = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGsxdb_jar_md5Octets(Octets _v_)
/*      */   {
/*  522 */     _xdb_verify_unsafe_();
/*  523 */     setGsxdb_jar_md5(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOpen_server_timestamp(long _v_)
/*      */   {
/*  530 */     _xdb_verify_unsafe_();
/*  531 */     xdb.Logs.logIf(new LogKey(this, "open_server_timestamp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  535 */         new xdb.logs.LogLong(this, GameServerInfo.this.open_server_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  539 */             GameServerInfo.this.open_server_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  543 */     });
/*  544 */     this.open_server_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCreate_role_num(int _v_)
/*      */   {
/*  551 */     _xdb_verify_unsafe_();
/*  552 */     xdb.Logs.logIf(new LogKey(this, "create_role_num")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  556 */         new xdb.logs.LogInt(this, GameServerInfo.this.create_role_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  560 */             GameServerInfo.this.create_role_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  564 */     });
/*  565 */     this.create_role_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  571 */     _xdb_verify_unsafe_();
/*  572 */     GameServerInfo _o_ = null;
/*  573 */     if ((_o1_ instanceof GameServerInfo)) { _o_ = (GameServerInfo)_o1_;
/*  574 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  575 */       return false;
/*  576 */     if (!this.zoneids.equals(_o_.zoneids)) return false;
/*  577 */     if (this.db_version != _o_.db_version) return false;
/*  578 */     if (this.time_offset != _o_.time_offset) return false;
/*  579 */     if (!this.gsxdb_jar_md5.equals(_o_.gsxdb_jar_md5)) return false;
/*  580 */     if (!this.disable_protocol_info.equals(_o_.disable_protocol_info)) return false;
/*  581 */     if (!this.module_fun_switches.equals(_o_.module_fun_switches)) return false;
/*  582 */     if (this.open_server_timestamp != _o_.open_server_timestamp) return false;
/*  583 */     if (this.create_role_num != _o_.create_role_num) return false;
/*  584 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  590 */     _xdb_verify_unsafe_();
/*  591 */     int _h_ = 0;
/*  592 */     _h_ += this.zoneids.hashCode();
/*  593 */     _h_ += this.db_version;
/*  594 */     _h_ = (int)(_h_ + this.time_offset);
/*  595 */     _h_ += this.gsxdb_jar_md5.hashCode();
/*  596 */     _h_ += this.disable_protocol_info.hashCode();
/*  597 */     _h_ += this.module_fun_switches.hashCode();
/*  598 */     _h_ = (int)(_h_ + this.open_server_timestamp);
/*  599 */     _h_ += this.create_role_num;
/*  600 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  606 */     _xdb_verify_unsafe_();
/*  607 */     StringBuilder _sb_ = new StringBuilder();
/*  608 */     _sb_.append("(");
/*  609 */     _sb_.append(this.zoneids);
/*  610 */     _sb_.append(",");
/*  611 */     _sb_.append(this.db_version);
/*  612 */     _sb_.append(",");
/*  613 */     _sb_.append(this.time_offset);
/*  614 */     _sb_.append(",");
/*  615 */     _sb_.append("'").append(this.gsxdb_jar_md5).append("'");
/*  616 */     _sb_.append(",");
/*  617 */     _sb_.append(this.disable_protocol_info);
/*  618 */     _sb_.append(",");
/*  619 */     _sb_.append(this.module_fun_switches);
/*  620 */     _sb_.append(",");
/*  621 */     _sb_.append(this.open_server_timestamp);
/*  622 */     _sb_.append(",");
/*  623 */     _sb_.append(this.create_role_num);
/*  624 */     _sb_.append(")");
/*  625 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  631 */     ListenableBean lb = new ListenableBean();
/*  632 */     lb.add(new ListenableChanged().setVarName("zoneids"));
/*  633 */     lb.add(new ListenableChanged().setVarName("db_version"));
/*  634 */     lb.add(new ListenableChanged().setVarName("time_offset"));
/*  635 */     lb.add(new ListenableChanged().setVarName("gsxdb_jar_md5"));
/*  636 */     lb.add(new ListenableChanged().setVarName("disable_protocol_info"));
/*  637 */     lb.add(new xdb.logs.ListenableMap().setVarName("module_fun_switches"));
/*  638 */     lb.add(new ListenableChanged().setVarName("open_server_timestamp"));
/*  639 */     lb.add(new ListenableChanged().setVarName("create_role_num"));
/*  640 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.GameServerInfo {
/*      */     private Const() {}
/*      */     
/*      */     GameServerInfo nThis() {
/*  647 */       return GameServerInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  653 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GameServerInfo copy()
/*      */     {
/*  659 */       return GameServerInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GameServerInfo toData()
/*      */     {
/*  665 */       return GameServerInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.GameServerInfo toBean()
/*      */     {
/*  670 */       return GameServerInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GameServerInfo toDataIf()
/*      */     {
/*  676 */       return GameServerInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.GameServerInfo toBeanIf()
/*      */     {
/*  681 */       return GameServerInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<String> getZoneids()
/*      */     {
/*  688 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  689 */       return xdb.Consts.constList(GameServerInfo.this.zoneids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<String> getZoneidsAsData()
/*      */     {
/*  695 */       GameServerInfo.this._xdb_verify_unsafe_();
/*      */       
/*  697 */       GameServerInfo _o_ = GameServerInfo.this;
/*  698 */       List<String> zoneids = new LinkedList();
/*  699 */       zoneids.addAll(_o_.zoneids);
/*  700 */       return zoneids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDb_version()
/*      */     {
/*  707 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  708 */       return GameServerInfo.this.db_version;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTime_offset()
/*      */     {
/*  715 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  716 */       return GameServerInfo.this.time_offset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getGsxdb_jar_md5()
/*      */     {
/*  723 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  724 */       return GameServerInfo.this.gsxdb_jar_md5;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getGsxdb_jar_md5Octets()
/*      */     {
/*  731 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  732 */       return GameServerInfo.this.getGsxdb_jar_md5Octets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.DisableProtocolInfo getDisable_protocol_info()
/*      */     {
/*  739 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  740 */       return (xbean.DisableProtocolInfo)xdb.Consts.toConst(GameServerInfo.this.disable_protocol_info);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ModuleFunSwitches> getModule_fun_switches()
/*      */     {
/*  747 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  748 */       return xdb.Consts.constMap(GameServerInfo.this.module_fun_switches);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ModuleFunSwitches> getModule_fun_switchesAsData()
/*      */     {
/*  755 */       GameServerInfo.this._xdb_verify_unsafe_();
/*      */       
/*  757 */       GameServerInfo _o_ = GameServerInfo.this;
/*  758 */       Map<Integer, xbean.ModuleFunSwitches> module_fun_switches = new HashMap();
/*  759 */       for (Map.Entry<Integer, xbean.ModuleFunSwitches> _e_ : _o_.module_fun_switches.entrySet())
/*  760 */         module_fun_switches.put(_e_.getKey(), new ModuleFunSwitches.Data((xbean.ModuleFunSwitches)_e_.getValue()));
/*  761 */       return module_fun_switches;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOpen_server_timestamp()
/*      */     {
/*  768 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  769 */       return GameServerInfo.this.open_server_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCreate_role_num()
/*      */     {
/*  776 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  777 */       return GameServerInfo.this.create_role_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDb_version(int _v_)
/*      */     {
/*  784 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  785 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTime_offset(long _v_)
/*      */     {
/*  792 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  793 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGsxdb_jar_md5(String _v_)
/*      */     {
/*  800 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  801 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGsxdb_jar_md5Octets(Octets _v_)
/*      */     {
/*  808 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  809 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOpen_server_timestamp(long _v_)
/*      */     {
/*  816 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  817 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreate_role_num(int _v_)
/*      */     {
/*  824 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  825 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  831 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  832 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  838 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  839 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  845 */       return GameServerInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  851 */       return GameServerInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  857 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  858 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  864 */       return GameServerInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  870 */       return GameServerInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  876 */       GameServerInfo.this._xdb_verify_unsafe_();
/*  877 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  883 */       return GameServerInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  889 */       return GameServerInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  895 */       return GameServerInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  901 */       return GameServerInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  907 */       return GameServerInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  913 */       return GameServerInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  919 */       return GameServerInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.GameServerInfo
/*      */   {
/*      */     private LinkedList<String> zoneids;
/*      */     
/*      */     private int db_version;
/*      */     
/*      */     private long time_offset;
/*      */     
/*      */     private String gsxdb_jar_md5;
/*      */     
/*      */     private xbean.DisableProtocolInfo disable_protocol_info;
/*      */     
/*      */     private HashMap<Integer, xbean.ModuleFunSwitches> module_fun_switches;
/*      */     
/*      */     private long open_server_timestamp;
/*      */     
/*      */     private int create_role_num;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  945 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  950 */       this.zoneids = new LinkedList();
/*  951 */       this.db_version = 1;
/*  952 */       this.time_offset = 0L;
/*  953 */       this.gsxdb_jar_md5 = "";
/*  954 */       this.disable_protocol_info = new DisableProtocolInfo.Data();
/*  955 */       this.module_fun_switches = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.GameServerInfo _o1_)
/*      */     {
/*  960 */       if ((_o1_ instanceof GameServerInfo)) { assign((GameServerInfo)_o1_);
/*  961 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  962 */       } else if ((_o1_ instanceof GameServerInfo.Const)) assign(((GameServerInfo.Const)_o1_).nThis()); else {
/*  963 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(GameServerInfo _o_) {
/*  968 */       this.zoneids = new LinkedList();
/*  969 */       this.zoneids.addAll(_o_.zoneids);
/*  970 */       this.db_version = _o_.db_version;
/*  971 */       this.time_offset = _o_.time_offset;
/*  972 */       this.gsxdb_jar_md5 = _o_.gsxdb_jar_md5;
/*  973 */       this.disable_protocol_info = new DisableProtocolInfo.Data(_o_.disable_protocol_info);
/*  974 */       this.module_fun_switches = new HashMap();
/*  975 */       for (Map.Entry<Integer, xbean.ModuleFunSwitches> _e_ : _o_.module_fun_switches.entrySet())
/*  976 */         this.module_fun_switches.put(_e_.getKey(), new ModuleFunSwitches.Data((xbean.ModuleFunSwitches)_e_.getValue()));
/*  977 */       this.open_server_timestamp = _o_.open_server_timestamp;
/*  978 */       this.create_role_num = _o_.create_role_num;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  983 */       this.zoneids = new LinkedList();
/*  984 */       this.zoneids.addAll(_o_.zoneids);
/*  985 */       this.db_version = _o_.db_version;
/*  986 */       this.time_offset = _o_.time_offset;
/*  987 */       this.gsxdb_jar_md5 = _o_.gsxdb_jar_md5;
/*  988 */       this.disable_protocol_info = new DisableProtocolInfo.Data(_o_.disable_protocol_info);
/*  989 */       this.module_fun_switches = new HashMap();
/*  990 */       for (Map.Entry<Integer, xbean.ModuleFunSwitches> _e_ : _o_.module_fun_switches.entrySet())
/*  991 */         this.module_fun_switches.put(_e_.getKey(), new ModuleFunSwitches.Data((xbean.ModuleFunSwitches)_e_.getValue()));
/*  992 */       this.open_server_timestamp = _o_.open_server_timestamp;
/*  993 */       this.create_role_num = _o_.create_role_num;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  999 */       _os_.compact_uint32(this.zoneids.size());
/* 1000 */       for (String _v_ : this.zoneids)
/*      */       {
/* 1002 */         _os_.marshal(_v_, "UTF-16LE");
/*      */       }
/* 1004 */       _os_.marshal(this.db_version);
/* 1005 */       _os_.marshal(this.time_offset);
/* 1006 */       _os_.marshal(this.gsxdb_jar_md5, "UTF-16LE");
/* 1007 */       this.disable_protocol_info.marshal(_os_);
/* 1008 */       _os_.compact_uint32(this.module_fun_switches.size());
/* 1009 */       for (Map.Entry<Integer, xbean.ModuleFunSwitches> _e_ : this.module_fun_switches.entrySet())
/*      */       {
/* 1011 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1012 */         ((xbean.ModuleFunSwitches)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1014 */       _os_.marshal(this.open_server_timestamp);
/* 1015 */       _os_.marshal(this.create_role_num);
/* 1016 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1022 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1024 */         String _v_ = "";
/* 1025 */         _v_ = _os_.unmarshal_String("UTF-16LE");
/* 1026 */         this.zoneids.add(_v_);
/*      */       }
/* 1028 */       this.db_version = _os_.unmarshal_int();
/* 1029 */       this.time_offset = _os_.unmarshal_long();
/* 1030 */       this.gsxdb_jar_md5 = _os_.unmarshal_String("UTF-16LE");
/* 1031 */       this.disable_protocol_info.unmarshal(_os_);
/*      */       
/* 1033 */       int size = _os_.uncompact_uint32();
/* 1034 */       if (size >= 12)
/*      */       {
/* 1036 */         this.module_fun_switches = new HashMap(size * 2);
/*      */       }
/* 1038 */       for (; size > 0; size--)
/*      */       {
/* 1040 */         int _k_ = 0;
/* 1041 */         _k_ = _os_.unmarshal_int();
/* 1042 */         xbean.ModuleFunSwitches _v_ = xbean.Pod.newModuleFunSwitchesData();
/* 1043 */         _v_.unmarshal(_os_);
/* 1044 */         this.module_fun_switches.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1047 */       this.open_server_timestamp = _os_.unmarshal_long();
/* 1048 */       this.create_role_num = _os_.unmarshal_int();
/* 1049 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1055 */       int _size_ = 0;
/* 1056 */       for (String _v_ : this.zoneids)
/*      */       {
/*      */         try
/*      */         {
/* 1060 */           _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(_v_, "UTF-16LE"));
/*      */         }
/*      */         catch (java.io.UnsupportedEncodingException e)
/*      */         {
/* 1064 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*      */         }
/*      */       }
/* 1067 */       _size_ += CodedOutputStream.computeInt32Size(2, this.db_version);
/* 1068 */       _size_ += CodedOutputStream.computeInt64Size(3, this.time_offset);
/*      */       try
/*      */       {
/* 1071 */         _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.gsxdb_jar_md5, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/* 1075 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1077 */       _size_ += CodedOutputStream.computeMessageSize(5, this.disable_protocol_info);
/* 1078 */       for (Map.Entry<Integer, xbean.ModuleFunSwitches> _e_ : this.module_fun_switches.entrySet())
/*      */       {
/* 1080 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/* 1081 */         _size_ += CodedOutputStream.computeMessageSize(6, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1083 */       _size_ += CodedOutputStream.computeInt64Size(7, this.open_server_timestamp);
/* 1084 */       _size_ += CodedOutputStream.computeInt32Size(8, this.create_role_num);
/* 1085 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1093 */         for (String _v_ : this.zoneids)
/*      */         {
/* 1095 */           _output_.writeBytes(1, ByteString.copyFrom(_v_, "UTF-16LE"));
/*      */         }
/* 1097 */         _output_.writeInt32(2, this.db_version);
/* 1098 */         _output_.writeInt64(3, this.time_offset);
/* 1099 */         _output_.writeBytes(4, ByteString.copyFrom(this.gsxdb_jar_md5, "UTF-16LE"));
/* 1100 */         _output_.writeMessage(5, this.disable_protocol_info);
/* 1101 */         for (Map.Entry<Integer, xbean.ModuleFunSwitches> _e_ : this.module_fun_switches.entrySet())
/*      */         {
/* 1103 */           _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/* 1104 */           _output_.writeMessage(6, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1106 */         _output_.writeInt64(7, this.open_server_timestamp);
/* 1107 */         _output_.writeInt32(8, this.create_role_num);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1111 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1113 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1121 */         boolean done = false;
/* 1122 */         while (!done)
/*      */         {
/* 1124 */           int tag = _input_.readTag();
/* 1125 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1129 */             done = true;
/* 1130 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/* 1134 */             String _v_ = "";
/* 1135 */             _v_ = _input_.readBytes().toString("UTF-16LE");
/* 1136 */             this.zoneids.add(_v_);
/* 1137 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1141 */             this.db_version = _input_.readInt32();
/* 1142 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1146 */             this.time_offset = _input_.readInt64();
/* 1147 */             break;
/*      */           
/*      */ 
/*      */           case 34: 
/* 1151 */             this.gsxdb_jar_md5 = _input_.readBytes().toString("UTF-16LE");
/* 1152 */             break;
/*      */           
/*      */ 
/*      */           case 42: 
/* 1156 */             _input_.readMessage(this.disable_protocol_info);
/* 1157 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1161 */             int _k_ = 0;
/* 1162 */             _k_ = _input_.readInt32();
/* 1163 */             int readTag = _input_.readTag();
/* 1164 */             if (50 != readTag)
/*      */             {
/* 1166 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1168 */             xbean.ModuleFunSwitches _v_ = xbean.Pod.newModuleFunSwitchesData();
/* 1169 */             _input_.readMessage(_v_);
/* 1170 */             this.module_fun_switches.put(Integer.valueOf(_k_), _v_);
/* 1171 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1175 */             this.open_server_timestamp = _input_.readInt64();
/* 1176 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1180 */             this.create_role_num = _input_.readInt32();
/* 1181 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1185 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1187 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1196 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1200 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1202 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GameServerInfo copy()
/*      */     {
/* 1208 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GameServerInfo toData()
/*      */     {
/* 1214 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.GameServerInfo toBean()
/*      */     {
/* 1219 */       return new GameServerInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GameServerInfo toDataIf()
/*      */     {
/* 1225 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.GameServerInfo toBeanIf()
/*      */     {
/* 1230 */       return new GameServerInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1236 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1240 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1244 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1248 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1252 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1256 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1260 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<String> getZoneids()
/*      */     {
/* 1267 */       return this.zoneids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<String> getZoneidsAsData()
/*      */     {
/* 1274 */       return this.zoneids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDb_version()
/*      */     {
/* 1281 */       return this.db_version;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTime_offset()
/*      */     {
/* 1288 */       return this.time_offset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getGsxdb_jar_md5()
/*      */     {
/* 1295 */       return this.gsxdb_jar_md5;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getGsxdb_jar_md5Octets()
/*      */     {
/* 1302 */       return Octets.wrap(getGsxdb_jar_md5(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.DisableProtocolInfo getDisable_protocol_info()
/*      */     {
/* 1309 */       return this.disable_protocol_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ModuleFunSwitches> getModule_fun_switches()
/*      */     {
/* 1316 */       return this.module_fun_switches;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ModuleFunSwitches> getModule_fun_switchesAsData()
/*      */     {
/* 1323 */       return this.module_fun_switches;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOpen_server_timestamp()
/*      */     {
/* 1330 */       return this.open_server_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCreate_role_num()
/*      */     {
/* 1337 */       return this.create_role_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDb_version(int _v_)
/*      */     {
/* 1344 */       this.db_version = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTime_offset(long _v_)
/*      */     {
/* 1351 */       this.time_offset = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGsxdb_jar_md5(String _v_)
/*      */     {
/* 1358 */       if (null == _v_)
/* 1359 */         throw new NullPointerException();
/* 1360 */       this.gsxdb_jar_md5 = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGsxdb_jar_md5Octets(Octets _v_)
/*      */     {
/* 1367 */       setGsxdb_jar_md5(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOpen_server_timestamp(long _v_)
/*      */     {
/* 1374 */       this.open_server_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreate_role_num(int _v_)
/*      */     {
/* 1381 */       this.create_role_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1387 */       if (!(_o1_ instanceof Data)) return false;
/* 1388 */       Data _o_ = (Data)_o1_;
/* 1389 */       if (!this.zoneids.equals(_o_.zoneids)) return false;
/* 1390 */       if (this.db_version != _o_.db_version) return false;
/* 1391 */       if (this.time_offset != _o_.time_offset) return false;
/* 1392 */       if (!this.gsxdb_jar_md5.equals(_o_.gsxdb_jar_md5)) return false;
/* 1393 */       if (!this.disable_protocol_info.equals(_o_.disable_protocol_info)) return false;
/* 1394 */       if (!this.module_fun_switches.equals(_o_.module_fun_switches)) return false;
/* 1395 */       if (this.open_server_timestamp != _o_.open_server_timestamp) return false;
/* 1396 */       if (this.create_role_num != _o_.create_role_num) return false;
/* 1397 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1403 */       int _h_ = 0;
/* 1404 */       _h_ += this.zoneids.hashCode();
/* 1405 */       _h_ += this.db_version;
/* 1406 */       _h_ = (int)(_h_ + this.time_offset);
/* 1407 */       _h_ += this.gsxdb_jar_md5.hashCode();
/* 1408 */       _h_ += this.disable_protocol_info.hashCode();
/* 1409 */       _h_ += this.module_fun_switches.hashCode();
/* 1410 */       _h_ = (int)(_h_ + this.open_server_timestamp);
/* 1411 */       _h_ += this.create_role_num;
/* 1412 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1418 */       StringBuilder _sb_ = new StringBuilder();
/* 1419 */       _sb_.append("(");
/* 1420 */       _sb_.append(this.zoneids);
/* 1421 */       _sb_.append(",");
/* 1422 */       _sb_.append(this.db_version);
/* 1423 */       _sb_.append(",");
/* 1424 */       _sb_.append(this.time_offset);
/* 1425 */       _sb_.append(",");
/* 1426 */       _sb_.append("'").append(this.gsxdb_jar_md5).append("'");
/* 1427 */       _sb_.append(",");
/* 1428 */       _sb_.append(this.disable_protocol_info);
/* 1429 */       _sb_.append(",");
/* 1430 */       _sb_.append(this.module_fun_switches);
/* 1431 */       _sb_.append(",");
/* 1432 */       _sb_.append(this.open_server_timestamp);
/* 1433 */       _sb_.append(",");
/* 1434 */       _sb_.append(this.create_role_num);
/* 1435 */       _sb_.append(")");
/* 1436 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GameServerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */